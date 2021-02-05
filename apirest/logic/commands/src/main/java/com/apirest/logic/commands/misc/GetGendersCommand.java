package com.apirest.logic.commands.misc;

import com.apirest.common.entities.Gender;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.dao.GenderDAO;
import com.apirest.persistence.dao.UserDAO;

import java.util.List;

public class GetGendersCommand extends Command<List<Gender>>
{
    private List<Gender> _genders;
    private GenderDAO _dao;

    public GetGendersCommand( )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a UpdateEmergencyState.CTOR: entity {}", entity );
        //endregion

        createSession( false );

        _dao = new GenderDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de UpdateEmergencyState.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        _genders = _dao.findAll();
    }

    @Override
    public List<Gender> getReturnParam()
    {
        return _genders;
    }
}
