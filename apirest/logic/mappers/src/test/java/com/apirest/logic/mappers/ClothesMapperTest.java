package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Accessories;
import com.apirest.common.entities.Clothes;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.dto.AccessoriesDTO;
import com.apirest.logic.dto.ClothesDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClothesMapperTest
{
    private Clothes _entity;
    private ClothesDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        Clothes entity = ClothesMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getStatus().getValue(), _dto._status );
        assertEquals( entity.getName(), _dto._name );
        assertEquals( entity.getRegisterDate().toString(), _dto._registerDate );
        assertEquals( entity.getCode(), _dto._code );
        assertEquals( entity.getColor(), _dto._color );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        ClothesDTO dto = ClothesMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._name, _entity.getName() );
        assertEquals( dto._registerDate, _entity.getRegisterDate().toString() );
        assertEquals( dto._code, _entity.getCode() );
        assertEquals( dto._color, _entity.getColor() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createClothes();

        _entity.setId( 1 );
        _entity.setStatus( MasterStatus.ACTIVE );
        _entity.setName( "name" );
        _entity.setRegisterDate( LocalDate.now() );
        _entity.setCode( "code" );
        _entity.setColor( "color" );
    }

    private void createDTO()
    {
        _dto = new ClothesDTO();

        _dto._id = _entity.getId();
        _dto._status = _entity.getStatus().getValue();
        _dto._name = _entity.getName();
        _dto._registerDate = _entity.getRegisterDate().toString();
        _dto._code = _entity.getCode();
        _dto._color = "color";
    }

}
