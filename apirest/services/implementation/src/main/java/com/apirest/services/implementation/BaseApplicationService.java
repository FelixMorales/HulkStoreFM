package com.apirest.services.implementation;

import com.apirest.common.exceptions.jwt.JWTVerifyException;
import com.apirest.common.utilities.JWT;
import com.apirest.common.utilities.Registry;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@ApplicationPath( "/api" )
public class BaseApplicationService extends Application
{
    //private static Logger _logger = LoggerFactory.getLogger( BaseApplicationService.class );

    @Override
    public Set<Class<?>> getClasses()
    {
        final Set<Class<?>> response = new HashSet<>();

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a BaseApplicationService.getClasses" );
        //endregion

        try
        {
            Registry.getInstance();
            response.add( UserService.class );
            response.add( MiscService.class );
            response.add( ProductService.class );
            response.add( InventoryService.class );
        }
        catch ( /*ConfigException*/ Exception e )
        {
            //_logger.error( e.getMessage(), e );

            throw new Error( e.getMessage(), e );
        }

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de BaseApplicationService.getClasses" );
        //endregion

        return response;
    }

    /**
     * Metodo que valida que el parametro proveido al servicio no sea nulo
     * @param object parametro que fue enviado al servicio
     */
    void verifyParams( Object object )
    {
        if ( object == null )
            throwException( Response.Status.BAD_REQUEST );
    }

    void verifyToken( String token )
    {
        try
        {
            JWT.verifyToken( token );
        }
        catch ( JWTVerifyException e )
        {
            //_logger.error( e.getMessage(), e );
            throwException( Response.Status.UNAUTHORIZED, e );
        }

    }

    /**
     * Metodo para enviar exceptions personalizadas al usuario
     * @param status estado HTTP de error a  informar
     * @param e Exception a mostrar
     */
    void throwException( Response.Status status, Exception e )
    {
        throw new WebApplicationException( Response.status( status ).entity( e ).build() );
    }

    /**
     * Metodo para enviar un exceiption unicamente con el estado
     * @param status estado HTTP de error a informar
     */
    private void throwException( Response.Status status )
    {
        throw new WebApplicationException( Response.status( status ).build() );
    }

}
