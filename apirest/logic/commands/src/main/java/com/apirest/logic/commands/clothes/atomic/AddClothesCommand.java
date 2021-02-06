package com.apirest.logic.commands.clothes.atomic;

import com.apirest.common.entities.Clothes;
import com.apirest.common.utilities.Security;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.dao.ClothesDAO;
import com.apirest.persistence.dao.UserDAO;

import java.time.LocalDate;

public class AddClothesCommand extends Command<Boolean>
{
    private Clothes _clothes;
    private ClothesDAO _dao;

    public AddClothesCommand( Clothes clothes )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a AddClothesCommand.CTOR: clothes {}", clothes );
        //endregion

        createSession( true );

        _clothes = clothes;
        _dao = new ClothesDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de AddClothesCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a AddClothesCommand.execute" );
        //endregion

        _clothes.setRegisterDate( LocalDate.now() );
        _clothes.setStatus( MasterStatus.ACTIVE );
        _dao.insert( _clothes );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de AddClothesCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
