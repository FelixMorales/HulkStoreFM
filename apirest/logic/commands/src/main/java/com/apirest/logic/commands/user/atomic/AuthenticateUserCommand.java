package com.apirest.logic.commands.user.atomic;

import com.apirest.common.entities.User;
import com.apirest.common.exceptions.security.WrongCredentialsException;
import com.apirest.common.utilities.Security;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.dao.UserDAO;

public class AuthenticateUserCommand extends Command<User>
{
    private User _user;
    private UserDAO _dao;

    public AuthenticateUserCommand( User user )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a AuthenticateUserCommand.CTOR: entity {}", entity );
        //endregion

        createSession( true );

        _user = user;
        _dao = new UserDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de AuthenticateUserCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a AuthenticateUserCommand.execute" );
        //endregion

        User entity = _dao.findByEmail( _user );

        if( !validatePassword( entity ) )
        {
            throw  new WrongCredentialsException();
        }

        _user = entity;

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de AuthenticateUserCommand.execute" );
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
