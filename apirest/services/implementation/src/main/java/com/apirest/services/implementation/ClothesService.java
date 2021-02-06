package com.apirest.services.implementation;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Clothes;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.common.exceptions.jwt.JWTVerifyException;
import com.apirest.common.utilities.JWT;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.logic.dto.ClothesDTO;
import com.apirest.logic.mappers.ClothesMapper;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/clothes" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ClothesService extends BaseApplicationService
{
    //private static Logger _logger = LoggerFactory.getLogger( UserService.class );

    @GET
    @Path("/addClothes")
    public void AddClothes( ClothesDTO clothes, @Context HttpServletRequest request )
    {
        //region Instrumentation
        //_logger.debug( "entrando a AddClothes: clothes {}", clothes );
        //endregion

        Clothes entity;

        verifyParams( clothes );
        verifyToken( request.getHeader( HttpHeaders.AUTHORIZATION) );

        try
        {
            entity = ClothesMapper.mapDtoToEntity( clothes );
            Command command = CommandFactory.createAddClothesCommand( entity );
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
        //_logger.debug( "saliendo de AddClothes" );
        //endregion
    }
}
