package com.apirest.logic.commands.inventory.atomic;

import com.apirest.common.entities.Inventory;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.InventoryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de agregar un producto al inventario.
 */
public class SupplyInventoryCommand extends Command<Boolean>
{
    private Inventory _inventoryItem;
    private InventoryDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( SupplyInventoryCommand.class );

    public SupplyInventoryCommand( Inventory inventoryItem )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a SupplyInventoryCommand.CTOR: inventoryItem {}", inventoryItem );
        //endregion

        createSession( true );

        _inventoryItem = inventoryItem;
        _dao = DAOFactory.createInventoryDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de SupplyInventoryCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a SupplyInventoryCommand.execute" );
        //endregion

        _inventoryItem.setQuantityAvailable( _inventoryItem.getQuantity() );
        _inventoryItem.setRegisterDate( LocalDateTime.now() );
        _inventoryItem.setStatus( MasterStatus.ACTIVE );
        _dao.insert( _inventoryItem );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de SupplyInventoryCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
