package com.apirest.logic.commands.shopCartItem;

import com.apirest.common.entities.ShopCartItem;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.ShopCartItemDAO;

import java.time.LocalDate;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar agregar un item al carrito de un usuario.
 */
public class AddShopCartItemCommand extends Command<Boolean>
{
    private ShopCartItem _shopCartItem;
    private ShopCartItemDAO _dao;

    public AddShopCartItemCommand( ShopCartItem shopCartItem )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a AddCartShopItemCommand.CTOR: entity {}", cartShopItem );
        //endregion

        createSession( true );

        _shopCartItem = shopCartItem;
        _dao = DAOFactory.createShopCartItemDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de AddCartShopItemCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a AddUserClientCommand.execute" );
        //endregion

        _shopCartItem.setRegisterDate( LocalDate.now() );
        _dao.insert( _shopCartItem );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de AddUserClientCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
