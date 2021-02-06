package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Clothes;
import com.apirest.common.entities.Inventory;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.dto.ClothesDTO;
import com.apirest.logic.dto.InventoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryMapperTest
{
    private Inventory _entity;
    private InventoryDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        Inventory entity = InventoryMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getStatus().getValue(), _dto._status );
        assertEquals( entity.getRegisterDate().toString(), _dto._registerDate );
        assertEquals( entity.getSupplyDate().toString(), _dto._supplyDate );
        assertEquals( entity.getUnitPrice(), _dto._unitPrice );
        assertEquals( entity.getQuantity(), _dto._quantity );
        assertEquals( entity.getQuantityAvailable(), _dto._quantityAvailable );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        InventoryDTO dto = InventoryMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._supplyDate, _entity.getSupplyDate().toString()  );
        assertEquals( dto._registerDate, _entity.getRegisterDate().toString() );
        assertEquals( dto._unitPrice, _entity.getUnitPrice() );
        assertEquals( dto._quantity, _entity.getQuantity() );
        assertEquals( dto._quantityAvailable, _entity.getQuantityAvailable() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createInventory();

        _entity.setId( 1 );
        _entity.setStatus( MasterStatus.ACTIVE );
        _entity.setRegisterDate( LocalDateTime.now() );
        _entity.setSupplyDate( LocalDateTime.now() );
        _entity.setUnitPrice( 15.05 );
        _entity.setQuantity( 10 );
        _entity.setQuantityAvailable( 5 );

    }

    private void createDTO()
    {
        _dto = new InventoryDTO();

        _dto._id = _entity.getId();
        _dto._status = _entity.getStatus().getValue();
        _dto._registerDate = _entity.getRegisterDate().toString();
        _dto._supplyDate = _entity.getSupplyDate().toString();
        _dto._unitPrice = _entity.getUnitPrice();
        _dto._quantity = _entity.getQuantity();
        _dto._quantityAvailable = _entity.getQuantityAvailable();
    }

}
