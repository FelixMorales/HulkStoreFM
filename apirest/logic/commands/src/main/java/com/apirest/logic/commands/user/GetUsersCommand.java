package com.apirest.logic.commands.user;

import com.apirest.common.entities.User;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.dao.UserDAO;

import java.util.List;

public class GetUsersCommand extends Command<List<User>>
{
    private List<User> _users;
    private UserDAO _dao;

    public GetUsersCommand( )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a UpdateEmergencyState.CTOR: entity {}", entity );
        //endregion

        createSession( false );

        _dao = new UserDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de UpdateEmergencyState.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        _users = _dao.findAll();
    }

    @Override
    public List<User> getReturnParam()
    {
        return _users;
    }
}
