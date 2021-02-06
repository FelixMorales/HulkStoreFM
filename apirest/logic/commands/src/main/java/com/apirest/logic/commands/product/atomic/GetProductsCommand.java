package com.apirest.logic.commands.product.atomic;

import com.apirest.common.entities.Product;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.ProductDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar la lista de productos.
 */
public class GetProductsCommand extends Command<List<Product>>
{
    private List<Product> _result;
    private ProductDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( GetProductsCommand.class );

    public GetProductsCommand( )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetProductsCommand.CTOR" );
        //endregion

        createSession( false );

        _dao = DAOFactory.createProductDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetProductsCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a GetProductsCommand.execute" );
        //endregion

        _result = _dao.findActives();

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de GetProductsCommand.execute" );
        //endregion
    }

    @Override
    public List<Product> getReturnParam()
    {
        return _result;
    }
}
