package com.apirest.logic.commands.inventory.atomic;

import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.Product;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.DBHandler;
import com.apirest.persistence.dao.InventoryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar el stock disponible de un producto.
 */
public class GetAvailableProductStockCommand extends Command<List<Inventory>>
{
    private List<Inventory> _result;
    private Product _entity;
    private InventoryDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( GetAvailableProductStockCommand.class );

    public GetAvailableProductStockCommand( Product product )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetAvailableProductStockCommand.CTOR: product {}", product );
        //endregion

        createSession( false );

        _entity = product;
        _dao = DAOFactory.createInventoryDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetAvailableProductStockCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    public GetAvailableProductStockCommand( Product product, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetAvailableProductStockCommand.CTOR: product {}", product );
        //endregion

        _entity = product;
        _dao = DAOFactory.createInventoryDAO( handler );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetAvailableProductStockCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a GetAvailableProductStockCommand.execute" );
        //endregion

        _result = _dao.findAvailableProductStock( _entity );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de GetAvailableProductStockCommand.execute" );
        //endregion
    }

    @Override
    public List<Inventory> getReturnParam()
    {
        return _result;
    }
}
