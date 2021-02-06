package com.apirest.logic.commands.shopCartItem;

import com.apirest.common.entities.ShopCartItem;
import com.apirest.common.entities.User;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.DBHandler;
import com.apirest.persistence.dao.ShopCartItemDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar los items del carrito de un usuario.
 */
public class GetShopCartItemsByUserCommand extends Command<List<ShopCartItem>>
{
    private User _user;
    private ShopCartItemDAO _dao;
    private List<ShopCartItem> _result;

    private static Logger _logger = LoggerFactory.getLogger( GetShopCartItemsByUserCommand.class );

    public GetShopCartItemsByUserCommand( User user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetShopCartItemsByUser.CTOR: entity {}", user );
        //endregion

        createSession( true );

        _user = user;
        _dao = DAOFactory.createShopCartItemDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetShopCartItemsByUser.CTOR: _dao {}", _dao );
        //endregion
    }

    public GetShopCartItemsByUserCommand( User user, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetShopCartItemsByUser.CTOR: entity {}", user );
        //endregion

        _user = user;
        _dao = DAOFactory.createShopCartItemDAO( handler );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetShopCartItemsByUser.CTOR: _dao {}", _dao );
        //endregion
    }


    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a GetShopCartItemsByUser.execute" );
        //endregion

        _result = _dao.findByUser( _user );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de GetShopCartItemsByUser.execute" );
        //endregion
    }

    @Override
    public List<ShopCartItem> getReturnParam()
    {
        return _result;
    }
}
