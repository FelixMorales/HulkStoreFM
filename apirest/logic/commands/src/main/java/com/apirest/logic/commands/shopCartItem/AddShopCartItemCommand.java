package com.apirest.logic.commands.shopCartItem;

import com.apirest.common.entities.ShopCartItem;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.ShopCartItemDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de agregar un item al carrito de un usuario.
 */
public class AddShopCartItemCommand extends Command<Boolean>
{
    private ShopCartItem _shopCartItem;
    private ShopCartItemDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( AddShopCartItemCommand.class );

    public AddShopCartItemCommand( ShopCartItem shopCartItem )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a AddCartShopItemCommand.CTOR: shopCartItem {}", shopCartItem );
        //endregion

        createSession( true );

        _shopCartItem = shopCartItem;
        _dao = DAOFactory.createShopCartItemDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de AddCartShopItemCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AddUserClientCommand.execute" );
        //endregion

        _shopCartItem.setRegisterDate( LocalDate.now() );
        _dao.insert( _shopCartItem );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AddUserClientCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
