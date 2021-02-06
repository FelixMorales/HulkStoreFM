package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Purchase;
import com.apirest.enums.PurchaseStatus;
import com.apirest.logic.dto.PurchaseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseMapperTest
{
    private Purchase _entity;
    private PurchaseDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        Purchase entity = PurchaseMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getStatus().getValue(), _dto._status );
        assertEquals( entity.getTax(), _dto._tax );
        assertEquals( entity.getNetPrice(), _dto._netPrice );
        assertEquals( entity.getGrossPrice(), _dto._grossPrice );
        assertEquals( entity.getPurchaseDate().toString(), _dto._purchaseDate );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        PurchaseDTO dto = PurchaseMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._tax, _entity.getTax() );
        assertEquals( dto._netPrice, _entity.getNetPrice() );
        assertEquals( dto._grossPrice, _entity.getGrossPrice() );
        assertEquals( dto._purchaseDate, _entity.getPurchaseDate().toString() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createPurchase();

        _entity.setId( 1 );
        _entity.setStatus( PurchaseStatus.DONE );
        _entity.setTax( 0.05 );
        _entity.setNetPrice( 100.50 );
        _entity.setGrossPrice( 87.2 );
        _entity.setPurchaseDate( LocalDate.now() );
    }

    private void createDTO()
    {
        _dto = new PurchaseDTO();

        _dto._id = _entity.getId();
        _dto._status = _entity.getStatus().getValue();
        _dto._tax = _entity.getTax();
        _dto._netPrice = _entity.getNetPrice();
        _dto._grossPrice = _entity.getGrossPrice();
        _dto._purchaseDate = _entity.getPurchaseDate().toString();
    }

}
