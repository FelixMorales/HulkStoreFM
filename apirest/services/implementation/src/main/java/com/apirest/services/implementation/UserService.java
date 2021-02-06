package com.apirest.services.implementation;

import com.apirest.common.entities.Purchase;
import com.apirest.common.entities.ShopCartItem;
import com.apirest.common.entities.User;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.common.exceptions.jpa.NotFoundException;
import com.apirest.common.exceptions.purchase.EmptyShopCartException;
import com.apirest.common.exceptions.purchase.EmptyStockException;
import com.apirest.common.exceptions.purchase.OutdatedPurchaseException;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.logic.dto.PurchaseDTO;
import com.apirest.logic.dto.ShopCartItemDTO;
import com.apirest.logic.dto.UserDTO;
import com.apirest.logic.mappers.PurchaseMapper;
import com.apirest.logic.mappers.ShopCartItemMapper;
import com.apirest.logic.mappers.UserMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path( "/user" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserService extends BaseApplicationService
{
    private static Logger _logger = LoggerFactory.getLogger( UserService.class );

    @POST
    @Path("/addClient")
    public void addClient( UserDTO user )
    {
        //region Instrumentation
        _logger.debug( "entrando a addClient: user {}", user );
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
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.BAD_REQUEST, e );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de addClient" );
        //endregion
    }

    @POST
    @Path("/authenticate")
    public UserDTO Authenticate( UserDTO user )
    {
        //region Instrumentation
        _logger.debug( "entrando a Authenticate: user {}", user );
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
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.BAD_REQUEST, e );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de Authenticate: response {}", response );
        //endregion

        return response;
    }

    @POST
    @Path("/addShopCartItem")
    public void addShopCartItem( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential, ShopCartItemDTO item )
    {
        //region Instrumentation
        _logger.debug( "entrando a supplyInventory: item {}", item );
        //endregion

        ShopCartItem entity;

        verifyParams( item );
        verifyToken( credential );

        try
        {
            entity = ShopCartItemMapper.mapDtoToEntity( item );
            Command command = CommandFactory.createAddShopCartItemCommand( entity );
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

    @POST
    @Path("/getShopCartItems")
    public List<ShopCartItemDTO> getShopCartItems( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential,
            UserDTO user )
    {
        //region Instrumentation
        _logger.debug( "entrando a supplyInventory: user {}", user );
        //endregion

        User entity;
        List<ShopCartItemDTO> response  = null;
        Command<List<ShopCartItem>> command;

        verifyParams( user );
        verifyToken( credential );

        try
        {
            entity = UserMapper.mapDtoToEntity( user );
            command = CommandFactory.createGetShopCartItemsByUserCommand( entity );
            command.execute();
            command.closeSession();

            response = ShopCartItemMapper.mapEntityListToDTOList( command.getReturnParam() );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de supplyInventory" );
        //endregion

        return response;
    }

    @POST
    @Path("/getPurchaseDetail")
    public PurchaseDTO getPurchaseDetail( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential, UserDTO user )
    {
        //region Instrumentation
        _logger.debug( "entrando a supplyInventory: user {}", user );
        //endregion

        User entity;
        PurchaseDTO response  = null;
        Command<Purchase> command;

        verifyParams( user );
        verifyToken( credential );

        try
        {
            entity = UserMapper.mapDtoToEntity( user );
            command = CommandFactory.createGeneratePurchaseDetailCommand( entity );
            command.execute();
            command.closeSession();

            response = PurchaseMapper.mapEntityToDto( command.getReturnParam() );
        }
        catch ( EmptyStockException | EmptyShopCartException e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.PRECONDITION_FAILED, e );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de supplyInventory" );
        //endregion

        return response;
    }

    @POST
    @Path("/executePurchase")
    public PurchaseDTO executePurchase( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential,
            PurchaseDTO purchase )
    {
        //region Instrumentation
        _logger.debug( "entrando a supplyInventory: purchase {}", purchase );
        //endregion

        Purchase entity;
        PurchaseDTO response  = null;
        Command<Purchase> command;

        verifyParams( purchase );
        verifyToken( credential );

        try
        {
            entity = PurchaseMapper.mapDtoToEntity( purchase );
            command = CommandFactory.createExecutePurchaseCommand( entity );
            command.execute();
            command.closeSession();

            response = PurchaseMapper.mapEntityToDto( command.getReturnParam() );
        }
        catch ( OutdatedPurchaseException e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.EXPECTATION_FAILED, e );
        }
        catch ( EmptyStockException | EmptyShopCartException e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.PRECONDITION_FAILED, e );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de supplyInventory" );
        //endregion

        return response;
    }
}
