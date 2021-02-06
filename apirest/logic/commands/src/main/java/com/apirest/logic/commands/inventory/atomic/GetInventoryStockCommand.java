package com.apirest.logic.commands.inventory.atomic;

import com.apirest.common.entities.Inventory;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.DBHandler;
import com.apirest.persistence.dao.InventoryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Name: GetInventoryStock
 * Description: Comando encargado de consultar la informacion del stock especificado.
 */
public class GetInventoryStockCommand extends Command<Inventory>
{
    private Inventory _result;
    private Inventory _entity;
    private InventoryDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( GetInventoryStockCommand.class );

    public GetInventoryStockCommand( Inventory product, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a GetInventoryStock.CTOR: product {}", product );
        //endregion

        _entity = product;
        _dao = DAOFactory.createInventoryDAO( handler );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de GetInventoryStock.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a GetInventoryStock.execute" );
        //endregion

        _result = _dao.find( _entity.getId() );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de GetInventoryStock.execute" );
        //endregion
    }

    @Override
    public Inventory getReturnParam()
    {
        return _result;
    }
}
