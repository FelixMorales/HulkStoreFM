package com.apirest.logic.commands.product.atomic;

import com.apirest.common.entities.Product;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.ProductDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de agregar un producto.
 */
public class AddProductCommand extends Command<Boolean>
{
    private Product _product;
    private ProductDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( AddProductCommand.class );

    public AddProductCommand( Product product )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a AddGeneralProductCommand.CTOR: product {}", product );
        //endregion

        createSession( true );

        _product = product;
        _dao = DAOFactory.createProductDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de AddGeneralProductCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AddGeneralProductCommand.execute" );
        //endregion

        _product.setRegisterDate( LocalDate.now() );
        _product.setStatus( MasterStatus.ACTIVE );
        _dao.insert( _product );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AddGeneralProductCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
