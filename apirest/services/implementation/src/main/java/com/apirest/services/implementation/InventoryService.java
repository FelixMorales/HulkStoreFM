package com.apirest.services.implementation;

import com.apirest.common.entities.Inventory;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.logic.dto.InventoryDTO;
import com.apirest.logic.mappers.InventoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/inventory" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class InventoryService extends BaseApplicationService
{
    private static Logger _logger = LoggerFactory.getLogger( InventoryService.class );

    @POST
    @Path("/supply")
    public void supplyInventory( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential, InventoryDTO inventoryItem )
    {
        //region Instrumentation
        _logger.debug( "entrando a supplyInventory: inventoryItem {}", inventoryItem );
        //endregion

        Inventory entity;

        verifyParams( inventoryItem );
        verifyToken( credential );

        try
        {
            entity = InventoryMapper.mapDtoToEntity( inventoryItem );
            Command command = CommandFactory.createSupplyInventoryCommand( entity );
            command.execute();
            command.closeSession();
        }
        catch ( ConstraintException e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.BAD_REQUEST, e );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de supplyInventory" );
        //endregion
    }
}
