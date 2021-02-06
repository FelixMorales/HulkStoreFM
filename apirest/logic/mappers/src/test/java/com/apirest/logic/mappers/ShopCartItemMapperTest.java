package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.ShopCartItem;
import com.apirest.logic.dto.ShopCartItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopCartItemMapperTest
{
    private ShopCartItem _entity;
    private ShopCartItemDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        ShopCartItem entity = ShopCartItemMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getRegisterDate().toString(), _dto._registerDate );
        assertEquals( entity.getQuantity(), _dto._quantity );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        ShopCartItemDTO dto = ShopCartItemMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._registerDate, _entity.getRegisterDate().toString());
        assertEquals( dto._quantity, _entity.getQuantity() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createShopCartItem();

        _entity.setId( 1 );
        _entity.setRegisterDate( LocalDate.now() );
        _entity.setQuantity( 10 );
    }

    private void createDTO()
    {
        _dto = new ShopCartItemDTO();

        _dto._id = _entity.getId();
        _dto._registerDate = _entity.getRegisterDate().toString();
        _dto._quantity = _entity.getQuantity();
    }

}
