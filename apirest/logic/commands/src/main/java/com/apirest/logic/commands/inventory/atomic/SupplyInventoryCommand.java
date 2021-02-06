package com.apirest.logic.commands.inventory.atomic;

import com.apirest.common.entities.Inventory;
import com.apirest.common.utilities.Security;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.InventoryDAO;

import java.time.LocalDateTime;

public class SupplyInventoryCommand extends Command<Boolean>
{
    private Inventory _inventoryItem;
    private InventoryDAO _dao;

    public SupplyInventoryCommand( Inventory inventoryItem )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "entrando a AddUserClientCommand.CTOR: entity {}", entity );
        //endregion

        createSession( true );

        _inventoryItem = inventoryItem;
        _dao = DAOFactory.createInventoryDAO( getHandler() );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de AddUserClientCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a AddUserClientCommand.execute" );
        //endregion

        _inventoryItem.setQuantityAvailable( _inventoryItem.getQuantity() );
        _inventoryItem.setRegisterDate( LocalDateTime.now() );
        _inventoryItem.setStatus( MasterStatus.ACTIVE );
        _dao.insert( _inventoryItem );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de AddUserClientCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
