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
import com.apirest.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de generar el detalle de compra antes de ejecutar la misma.
 */
public class GeneratePurchaseDetailCommand extends Command<Purchase>
{
    private Purchase _result;
    private User _user;
    private DBHandler _handler;

    private Command<List<ShopCartItem>> _getShopCartItems;
    private Command<List<Inventory>> _getProductStock;

    private static Logger _logger = LoggerFactory.getLogger( GeneratePurchaseDetailCommand.class );

    public GeneratePurchaseDetailCommand( User user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GeneratePurchaseDetailCommand.CTOR: user {}", user );
        //endregion

        createSession( false );

        _handler = getHandler();
        _user = user;
        _getShopCartItems = CommandFactory.createGetShopCartItemsByUserCommand( _user, _handler );
        _result = EntityFactory.createPurchase();

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GeneratePurchaseDetailCommand.CTOR" );
        //endregion
    }

    public GeneratePurchaseDetailCommand( User user, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GeneratePurchaseDetailCommand.CTOR: user {}", user );
        //endregion

        _user = user;
        _handler = handler;
        _getShopCartItems = CommandFactory.createGetShopCartItemsByUserCommand( _user, _handler );
        _result = EntityFactory.createPurchase();

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GeneratePurchaseDetailCommand.CTOR" );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a GeneratePurchaseDetailCommand.execute" );
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
            _getProductStock = CommandFactory.createGetAvailableProductStockCommand( item.getProduct(), _handler );
            _getProductStock.execute();
            generatePurchaseDetail( _getProductStock.getReturnParam(), item );
        }

        generatePurchasePrice();

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de GeneratePurchaseDetailCommand.execute" );
        //endregion
    }

    private void generatePurchaseDetail( List<Inventory> stockItems, ShopCartItem shopCartItem )
    {
        if ( stockItems == null || stockItems.isEmpty() )
            throw new EmptyStockException();

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

        double netPrice = grossPrice + (grossPrice * _result.getTax());

        _result.setNetPrice( netPrice );
    }

    @Override
    public Purchase getReturnParam()
    {
        return _result;
    }
}
