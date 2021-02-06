package com.apirest.logic.commands;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.Product;
import com.apirest.enums.MasterStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryCommandsTest
{
    Product _product;
    Inventory _inventory;

    @BeforeEach
    public void setUp()
    {
        _product = EntityFactory.createProduct();
        _product.setId( 1 );

        _inventory = EntityFactory.createInventory();
        _inventory.setProduct( EntityFactory.createProduct() );
        _inventory.getProduct().setId( 1 );
        _inventory.setUnitPrice( 10.5 );
        _inventory.setQuantity( 5 );
        _inventory.setSupplyDate( LocalDateTime.now() );
    }

    @Test
    public void SupplyInventoryCommandTest()
    {
        Command command = CommandFactory.createSupplyInventoryCommand( _inventory );
        command.execute();
        command.closeSession();

        assertTrue( _inventory.getId() > 0 );
    }

    @Test
    public void GetAllAvailableStockCommandTest()
    {

        Command supplyInventoryCommand = CommandFactory.createSupplyInventoryCommand( _inventory );
        supplyInventoryCommand.execute();
        supplyInventoryCommand.closeSession();

        Command<List<Inventory>> getAllAvailableStockCommand = CommandFactory.createGetAllAvailableStockCommand();
        getAllAvailableStockCommand.execute();
        getAllAvailableStockCommand.closeSession();

        assertTrue(getAllAvailableStockCommand.getReturnParam().size() > 0);

        for ( Inventory item : getAllAvailableStockCommand.getReturnParam() )
        {
            assertEquals( item.getStatus(), MasterStatus.ACTIVE );
            assertTrue( item.getQuantityAvailable() > 0 );
        }

    }

    @Test
    public void GetAvailableProductStockCommandTest()
    {

        Command supplyInventoryCommand = CommandFactory.createSupplyInventoryCommand( _inventory );
        supplyInventoryCommand.execute();
        supplyInventoryCommand.closeSession();

        Command<List<Inventory>> getAvailableProductStockCommand = CommandFactory.createGetAvailableProductStockCommand( _product );
        getAvailableProductStockCommand.execute();
        getAvailableProductStockCommand.closeSession();

        assertTrue(getAvailableProductStockCommand.getReturnParam().size() > 0);

        for ( Inventory item : getAvailableProductStockCommand.getReturnParam() )
        {
            assertEquals( item.getStatus(), MasterStatus.ACTIVE );
            assertEquals( item.getProduct().getId(), _product.getId() );
            assertTrue( item.getQuantityAvailable() > 0 );
        }
    }

    @Test
    public void GetInventoryStockCommandTest()
    {

        Command supplyInventoryCommand = CommandFactory.createSupplyInventoryCommand( _inventory );
        supplyInventoryCommand.execute();
        supplyInventoryCommand.closeSession();

        Inventory testInventory = EntityFactory.createInventory();
        testInventory.setId( _inventory.getId() );

        Command<Inventory> getInventoryStockCommand = CommandFactory.createGetInventoryStockCommand( testInventory );
        getInventoryStockCommand.execute();
        getInventoryStockCommand.closeSession();

        assertEquals( getInventoryStockCommand.getReturnParam().getId(), _inventory.getId() );
        assertEquals(  getInventoryStockCommand.getReturnParam().getProduct().getId(), _inventory.getProduct().getId() );
        assertEquals(  getInventoryStockCommand.getReturnParam().getQuantityAvailable(), _inventory.getQuantityAvailable() );
        assertEquals(  getInventoryStockCommand.getReturnParam().getUnitPrice(), _inventory.getUnitPrice() );
    }


}
