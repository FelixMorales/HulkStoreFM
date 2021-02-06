package com.apirest.logic.commands.inventory.atomic;

import com.apirest.common.entities.Inventory;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.InventoryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de consultar el stock disponible de todos los productos.
 */
public class GetAllAvailableStockCommand extends Command<List<Inventory>>
{
    private List<Inventory> _result;
    private InventoryDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( GetAllAvailableStockCommand.class );

    public GetAllAvailableStockCommand( )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetAllAvailableStockCommand.CTOR" );
        //endregion

        createSession( false );

        _dao = DAOFactory.createInventoryDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetAllAvailableStockCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a GetAllAvailableStockCommand.execute" );
        //endregion

        _result = _dao.findAvailableStock();

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de GetAllAvailableStockCommand.execute" );
        //endregion
    }

    @Override
    public List<Inventory> getReturnParam()
    {
        return _result;
    }
}
