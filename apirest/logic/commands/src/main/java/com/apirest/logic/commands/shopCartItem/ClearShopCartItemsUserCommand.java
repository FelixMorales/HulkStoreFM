package com.apirest.logic.commands.shopCartItem;

import com.apirest.common.entities.User;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.DBHandler;
import com.apirest.persistence.dao.ShopCartItemDAO;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar los items del carrito de un usuario.
 */
public class ClearShopCartItemsUserCommand extends Command<Boolean>
{
    private User _user;
    private ShopCartItemDAO _dao;

    public ClearShopCartItemsUserCommand( User user, DBHandler handler )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a ClearShopCartItemsUserCommand.CTOR: entity {}", user );
        //endregion

        _user = user;
        _dao = DAOFactory.createShopCartItemDAO( handler );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de ClearShopCartItemsUserCommand.CTOR: _dao {}", _dao );
        //endregion
    }


    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a ClearShopCartItemsUserCommand.execute" );
        //endregion

        _dao.clearItems( _user );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de ClearShopCartItemsUserCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
