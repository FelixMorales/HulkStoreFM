package com.apirest.logic.commands.user.atomic;

import com.apirest.common.entities.User;
import com.apirest.common.exceptions.security.WrongCredentialsException;
import com.apirest.common.utilities.JWT;
import com.apirest.common.utilities.Security;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de realizar la autenticacion de un usuario.
 */
public class AuthenticateUserCommand extends Command<User>
{
    private User _user;
    private UserDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( AuthenticateUserCommand.class );

    public AuthenticateUserCommand( User user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a AuthenticateUserCommand.CTOR: entity {}", user );
        //endregion

        createSession( true );

        _user = user;
        _dao = DAOFactory.createUserDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de AuthenticateUserCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AuthenticateUserCommand.execute" );
        //endregion

        User entity = _dao.findByEmail( _user );

        if( !validatePassword( entity ) )
        {
            throw  new WrongCredentialsException();
        }

        _user = entity;
        _user.setToken( JWT.createToken( String.valueOf( _user.getType().getValue() ),
                                         String.valueOf( _user.getId() ) ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AuthenticateUserCommand.execute" );
        //endregion
    }

    private boolean validatePassword( User enity )
    {
        final String password = Security.hashPassword( _user.getPassword(), enity.getSalt() );

        boolean result = false;

        if ( password.equals( enity.getPassword() ) )
        {
            result = true;
        }

        return result;
    }

    @Override
    public User getReturnParam()
    {
        return _user;
    }
}
