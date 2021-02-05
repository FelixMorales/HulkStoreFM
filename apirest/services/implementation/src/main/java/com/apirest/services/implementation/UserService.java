package com.apirest.services.implementation;

import com.apirest.common.entities.User;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.common.exceptions.jpa.NotFoundException;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.logic.dto.UserDTO;
import com.apirest.logic.mappers.UserMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/user" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserService extends BaseApplicationService
{
    //private static Logger _logger = LoggerFactory.getLogger( UserService.class );

    @POST
    @Path("/addClient")
    public void addClient( UserDTO user )
    {
        //region Instrumentation
        //_logger.debug( "entrando a addClient: user {}", user );
        //endregion

        User entity;

        verifyParams( user );

        try
        {
            entity = UserMapper.mapDtoToEntity( user );
            Command command = CommandFactory.createAddUserClientCommand( entity );
            command.execute();
            command.closeSession();
        }
        catch ( ConstraintException e )
        {
            //_logger.error( e.getMessage(), e );
            throwException( Response.Status.BAD_REQUEST, e );
        }
        catch ( Exception e )
        {
            //_logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        //_logger.debug( "saliendo de addClient" );
        //endregion
    }

    @POST
    @Path("/authenticate")
    public UserDTO Authenticate( UserDTO user )
    {
        //region Instrumentation
        //_logger.debug( "entrando a Authenticate: user {}", user );
        //endregion

        User entity;
        UserDTO response = null;
        Command<User> command;

        verifyParams( user );

        try
        {
            entity = UserMapper.mapDtoToEntity( user );
            command = CommandFactory.createAuthenticateUserCommand( entity );
            command.execute();
            command.closeSession();

            response = UserMapper.mapEntityToDto( command.getReturnParam() );
        }
        catch ( NotFoundException e )
        {
            //_logger.error( e.getMessage(), e );
            throwException( Response.Status.BAD_REQUEST, e );
        }
        catch ( Exception e )
        {
            //_logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        //_logger.debug( "saliendo de Authenticate: response {}", response );
        //endregion

        return response;
    }
}
