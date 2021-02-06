package com.apirest.services.implementation;

import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.Product;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.common.exceptions.jpa.FindAllException;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.logic.dto.InventoryDTO;
import com.apirest.logic.dto.ProductDTO;
import com.apirest.logic.mappers.InventoryMapper;
import com.apirest.logic.mappers.ProductMapper;
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
import java.util.List;

@Path( "/inventory" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class InventoryService extends BaseApplicationService
{
    private static Logger _logger = LoggerFactory.getLogger( InventoryService.class );

    /**
     * Name: supplyInventory
     * Description: Servicio encargado de agregar el item al inventario.
     */
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

    /**
     * Name: getAvailableStock
     * Description: Servicio encargado de consultar el stock actual del inventario
     */
    @POST
    @Path("/getAvailableStock")
    public List<InventoryDTO> getAvailableStock( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential )
    {
        //region Instrumentation
        _logger.debug( "entrando a getAvailableStock" );
        //endregion

        verifyToken( credential );

        List<InventoryDTO> response = null;
        Command<List<Inventory>> command;
        try
        {
            command = CommandFactory.createGetAllAvailableStockCommand( );
            command.execute();
            command.closeSession();

            response = InventoryMapper.mapEntityListToDTOList( command.getReturnParam() );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de getAvailableStock: response {}", response );
        //endregion

        return response;
    }

    /**
     * Name: getAvailableProductStock
     * Description: Servicio encargado de consultar el stock actual del producto especificado
     */
    @POST
    @Path("/getAvailableProductStock")
    public List<InventoryDTO> getAvailableProductStock( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential,
            ProductDTO product )
    {
        //region Instrumentation
        _logger.debug( "entrando a getAvailableProductStock: product {}", product );
        //endregion

        verifyParams( product );
        verifyToken( credential );

        Product entity;
        List<InventoryDTO> response = null;
        Command<List<Inventory>> command;

        try
        {
            entity = ProductMapper.mapDtoToEntity( product );
            command = CommandFactory.createGetAvailableProductStockCommand( entity );
            command.execute();
            command.closeSession();

            response = InventoryMapper.mapEntityListToDTOList( command.getReturnParam() );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de getAvailableProductStock: response {}", response );
        //endregion

        return response;
    }
}
