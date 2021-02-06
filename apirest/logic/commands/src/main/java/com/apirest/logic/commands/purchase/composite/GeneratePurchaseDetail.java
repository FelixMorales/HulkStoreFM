package com.apirest.logic.commands.purchase.composite;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.PurchaseDetail;
import com.apirest.common.entities.ShopCartItem;
import com.apirest.common.entities.Purchase;
import com.apirest.common.entities.User;
import com.apirest.common.exceptions.purchase.EmptyShopCartException;
import com.apirest.common.exceptions.purchase.EmptyStockException;
import com.apirest.enums.PurchaseStatus;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.InventoryDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de generar el detalle de compra antes de ejecutar la misma.
 */
public class GeneratePurchaseDetail extends Command<Purchase>
{
    private Purchase _result;
    private User _user;
    private InventoryDAO _inventoryDAO;

    private Command<List<ShopCartItem>> _getShopCartItems;

    public GeneratePurchaseDetail( User user )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a AddUserClientCommand.CTOR: entity {}", entity );
        //endregion

        createSession( false );

        _user = user;
        _inventoryDAO = DAOFactory.createInventoryDAO( getHandler() );
        _getShopCartItems = CommandFactory.createGetShopCartItemsByUser( _user, getHandler() );
        _result = EntityFactory.createPurchase();

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de AddUserClientCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a AddUserClientCommand.execute" );
        //endregion

        _getShopCartItems.execute();
        List<ShopCartItem> items = _getShopCartItems.getReturnParam();

        if( items == null || items.isEmpty() )
            throw new EmptyShopCartException(  );

        _result.setUser( _user );
        _result.setPurchaseDate( LocalDate.now() );
        _result.setStatus( PurchaseStatus.PENDING );
        _result.setPurchaseDetailList( new ArrayList<>(  ) );

        for( ShopCartItem item : items )
        {
            List<Inventory> stockItems = _inventoryDAO.findAvailableProductStock( item.getProduct() );

            if ( stockItems == null || stockItems.isEmpty() )
                throw new EmptyStockException();

            generatePurchaseDetail( stockItems, item );
        }

        generatePurchasePrice();

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de AddUserClientCommand.execute" );
        //endregion
    }

    private void generatePurchaseDetail( List<Inventory> stockItems, ShopCartItem shopCartItem )
    {
        int remainingItems = shopCartItem.getQuantity();

        for( Inventory stockItem : stockItems )
        {
            int quantity;

            if( remainingItems >= stockItem.getQuantityAvailable() )
                quantity = stockItem.getQuantityAvailable();
            else
                quantity = remainingItems;

            remainingItems -= stockItem.getQuantityAvailable();

            PurchaseDetail purchaseDetail = EntityFactory.createPurchaseDetail();
            purchaseDetail.setPurchase( _result );
            purchaseDetail.setInventory( stockItem );
            purchaseDetail.setUnitPrice( stockItem.getUnitPrice() );
            purchaseDetail.setQuantity( quantity );

            _result.getPurchaseDetailList().add( purchaseDetail );

            if(remainingItems <= 0)
                break;
        }

        if ( remainingItems > 0 )
            throw new EmptyStockException();
    }

    private void generatePurchasePrice()
    {
        double grossPrice = 0.0;

        for( PurchaseDetail purchaseDetail : _result.getPurchaseDetailList() )
        {
            grossPrice += purchaseDetail.getUnitPrice() * purchaseDetail.getQuantity();
        }

        _result.setGrossPrice( grossPrice );
        _result.setNetPrice( grossPrice );
    }

    @Override
    public Purchase getReturnParam()
    {
        return _result;
    }
}
