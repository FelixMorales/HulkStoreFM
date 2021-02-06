package com.apirest.services.implementation;

import com.apirest.common.entities.Accessories;
import com.apirest.common.entities.Clothes;
import com.apirest.common.entities.Product;
import com.apirest.common.entities.Toy;
import com.apirest.common.entities.Utensil;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.CommandFactory;
import com.apirest.logic.dto.AccessoriesDTO;
import com.apirest.logic.dto.ClothesDTO;
import com.apirest.logic.dto.ProductDTO;
import com.apirest.logic.dto.ToyDTO;
import com.apirest.logic.dto.UtensilDTO;
import com.apirest.logic.mappers.AccessoriesMapper;
import com.apirest.logic.mappers.ClothesMapper;
import com.apirest.logic.mappers.ProductMapper;
import com.apirest.logic.mappers.ToyMapper;
import com.apirest.logic.mappers.UtensilMapper;
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

@Path( "/product" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ProductService extends BaseApplicationService
{
    private static Logger _logger = LoggerFactory.getLogger( ProductService.class );

    /**
     * Name: getActivesProducts
     * Description: Servicio encargado de consultar los productos activos del sistema.
     */
    @POST
    @Path("/getActivesProducts")
    public List<ProductDTO> getActivesProducts( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential )
    {
        //region Instrumentation
        _logger.debug( "entrando a getActivesProducts" );
        //endregion

        List<ProductDTO> response = null;
        Command<List<Product>> command;

        verifyToken( credential );

        try
        {
            command = CommandFactory.createGetProductsCommand( );
            command.execute();
            command.closeSession();

            response = ProductMapper.mapEntityListToDTOList( command.getReturnParam() );
        }
        catch ( Exception e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.INTERNAL_SERVER_ERROR, e );
        }

        //region Instrumentation
        _logger.debug( "saliendo de getActivesProducts: response {}", response );
        //endregion

        return response;
    }

    /**
     * Name: addProduct
     * Description: Servicio encargado de agregar un producto general (comic)
     */
    @POST
    @Path("/addProduct")
    public void addProduct( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential, ProductDTO product )
    {
        //region Instrumentation
        _logger.debug( "entrando a addProduct: product {}", product );
        //endregion

        Product entity;

        verifyParams( product );
        verifyToken( credential );

        try
        {
            entity = ProductMapper.mapDtoToEntity( product );
            Command command = CommandFactory.createAddProductCommand( entity );
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
        _logger.debug( "saliendo de addProduct" );
        //endregion
    }

    /**
     * Name: addClothes
     * Description: Servicio encargado de agregar un producto tipo ropa (camiseta, pantalon, etc)
     */
    @POST
    @Path("/addClothes")
    public void addClothes( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential, ClothesDTO clothes )
    {
        //region Instrumentation
        _logger.debug( "entrando a AddClothes: clothes {}", clothes );
        //endregion

        Clothes entity;

        verifyParams( clothes );
        verifyToken( credential );

        try
        {
            entity = ClothesMapper.mapDtoToEntity( clothes );
            Command command = CommandFactory.createAddProductCommand( entity );
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
        _logger.debug( "saliendo de AddClothes" );
        //endregion
    }

    /**
     * Name: addAccessory
     * Description: Servicio encargado de agregar un producto tipo accesorio
     */
    @POST
    @Path("/addAccessory")
    public void addAccessory( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential,
            AccessoriesDTO accessories )
    {
        //region Instrumentation
        _logger.debug( "entrando a addAccessory: accessories {}", accessories );
        //endregion

        Accessories entity;

        verifyParams( accessories );
        verifyToken( credential );

        try
        {
            entity = AccessoriesMapper.mapDtoToEntity( accessories );
            Command command = CommandFactory.createAddProductCommand( entity );
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
        _logger.debug( "saliendo de addAccessory" );
        //endregion
    }

    /**
     * Name: addToy
     * Description: Servicio encargado de agregar un producto tipo juguete
     */
    @POST
    @Path("/addToy")
    public void addToy( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential,
            ToyDTO toy )
    {
        //region Instrumentation
        _logger.debug( "entrando a addToy: toy {}", toy );
        //endregion

        Toy entity;

        verifyParams( toy );
        verifyToken( credential );

        try
        {
            entity = ToyMapper.mapDtoToEntity( toy );
            Command command = CommandFactory.createAddProductCommand( entity );
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
        _logger.debug( "saliendo de addToy" );
        //endregion
    }

    /**
     * Name: addUtensil
     * Description: Servicio encargado de agregar un producto tipo utensilio (vasos, termos, etc)
     */
    @POST
    @Path("/addUtensil")
    public void addUtensil( @HeaderParam( HttpHeaders.AUTHORIZATION ) String credential,
            UtensilDTO utensil )
    {
        //region Instrumentation
        _logger.debug( "entrando a addUtensil: utensil {}", utensil );
        //endregion

        Utensil entity;

        verifyParams( utensil );
        verifyToken( credential );

        try
        {
            entity = UtensilMapper.mapDtoToEntity( utensil );
            Command command = CommandFactory.createAddProductCommand( entity );
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
        _logger.debug( "saliendo de addUtensil" );
        //endregion
    }
}
