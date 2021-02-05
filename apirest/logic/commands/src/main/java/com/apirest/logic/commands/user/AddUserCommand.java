package com.apirest.logic.commands.user;

import com.apirest.common.entities.User;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.dao.UserDAO;

public class AddUserCommand extends Command<Boolean>
{
    private User _entity;
    private UserDAO _dao;

    public AddUserCommand( )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a UpdateEmergencyState.CTOR: entity {}", entity );
        //endregion

        createSession( true );

        _entity = new User(  );
        _dao = new UserDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de UpdateEmergencyState.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        _entity.setName( "felix" );
        _dao.insert( _entity );
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
