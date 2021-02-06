package com.apirest.logic.commands.purchase.composite;

import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.Purchase;
import com.apirest.common.entities.PurchaseDetail;
import com.apirest.common.exceptions.purchase.EmptyStockException;
import com.apirest.common.exceptions.purchase.OutdatedPurchaseException;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.PurchaseStatus;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.PurchaseDAO;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de ejecutar la compra.
 */
public class ExecutePurchaseCommand extends Command<Purchase>
{
    private Purchase _purchase;
    private Purchase _result;
    private Command<Purchase> getPurchaseDetail;
    private Command<Inventory> getCurrentInventory;

    public ExecutePurchaseCommand( Purchase purchase )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a ExecutePurchaseCommand.CTOR: entity {}", purchase );
        //endregion

        createSession( true );

        _purchase = purchase;
        getPurchaseDetail = CommandFactory.createGeneratePurchaseDetailCommand( _purchase.getUser(), getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de ExecutePurchaseCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a ExecutePurchaseCommand.execute" );
        //endregion

        getPurchaseDetail.execute();
        Purchase currentPurchase = getPurchaseDetail.getReturnParam();

        if( _purchase.getNetPrice() != currentPurchase.getNetPrice() )
            throw new OutdatedPurchaseException();

        for( PurchaseDetail purchaseDetail : currentPurchase.getPurchaseDetailList() )
        {
            updateStock( purchaseDetail );
        }

        currentPurchase.setStatus( PurchaseStatus.DONE  );
        CommandFactory.createAddPurchaseCommand( currentPurchase, getHandler() ).execute();
        CommandFactory.createClearShopCartItemsUserCommand( _purchase.getUser(), getHandler() ).execute();

        _result = currentPurchase;

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de ExecutePurchaseCommand.execute" );
        //endregion
    }

    private void updateStock( PurchaseDetail purchaseDetail )
    {
        getCurrentInventory = CommandFactory.createGetInventoryStockCommand( purchaseDetail.getInventory(), getHandler() );
        getCurrentInventory.execute();
        Inventory stockItem = getCurrentInventory.getReturnParam();

        if ( stockItem.getQuantityAvailable() < purchaseDetail.getQuantity() )
            throw new EmptyStockException();

        stockItem.setQuantityAvailable( stockItem.getQuantityAvailable() - purchaseDetail.getQuantity() );
    }

    @Override
    public Purchase getReturnParam()
    {
        return _result;
    }
}
