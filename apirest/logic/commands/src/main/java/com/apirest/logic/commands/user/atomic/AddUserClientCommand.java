package com.apirest.logic.commands.user.atomic;

import com.apirest.common.entities.User;
import com.apirest.common.utilities.Security;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de registrar un usuario tipo cliente.
 */
public class AddUserClientCommand extends Command<Boolean>
{
    private User _user;
    private UserDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( AddUserClientCommand.class );

    public AddUserClientCommand( User user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a AddUserClientCommand.CTOR: user {}", user );
        //endregion

        createSession( true );

        _user = user;
        _dao = DAOFactory.createUserDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de AddUserClientCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AddUserClientCommand.execute" );
        //endregion

        _user.setRegisterDate( LocalDate.now() );
        _user.setStatus( MasterStatus.ACTIVE );
        _user.setType( UserType.CLIENT );
        _user.setSalt( Security.generateSalt() );
        _user.setPassword( Security.hashPassword(  _user.getPassword(), _user.getSalt()) );
        _dao.insert( _user );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AddUserClientCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
