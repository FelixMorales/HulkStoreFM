package com.apirest.logic.commands.cartShopItem;

import com.apirest.common.entities.CartShopItem;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.CartShopItemDAO;

import java.time.LocalDate;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar agregar un item al carrito de un usuario.
 */
public class AddCartShopItemCommand extends Command<Boolean>
{
    private CartShopItem _cartShopItem;
    private CartShopItemDAO _dao;

    public AddCartShopItemCommand( CartShopItem cartShopItem )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a AddCartShopItemCommand.CTOR: entity {}", cartShopItem );
        //endregion

        createSession( true );

        _cartShopItem = cartShopItem;
        _dao = DAOFactory.createCartShopItemDAO( getHandler() );

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

        _cartShopItem.setRegisterDate( LocalDate.now() );
        _dao.insert( _cartShopItem );

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
