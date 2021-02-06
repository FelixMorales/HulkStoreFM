package com.apirest.logic.commands.cartShopItem;

import com.apirest.common.entities.CartShopItem;
import com.apirest.common.entities.User;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.CartShopItemDAO;

import java.time.LocalDate;
import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar los items del carrito de un usuario.
 */
public class GetCartShopItemsByUser extends Command<List<CartShopItem>>
{
    private User _user;
    private CartShopItemDAO _dao;
    private List<CartShopItem> _result;

    public GetCartShopItemsByUser( User user )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a GetCartShopItemsByUser.CTOR: entity {}", user );
        //endregion

        createSession( true );

        _user = user;
        _dao = DAOFactory.createCartShopItemDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de GetCartShopItemsByUser.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a GetCartShopItemsByUser.execute" );
        //endregion

        _result = _dao.findByUser( _user );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de GetCartShopItemsByUser.execute" );
        //endregion
    }

    @Override
    public List<CartShopItem> getReturnParam()
    {
        return _result;
    }
}
