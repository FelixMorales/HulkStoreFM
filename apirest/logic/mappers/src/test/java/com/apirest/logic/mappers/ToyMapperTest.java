package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Toy;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.dto.ToyDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyMapperTest
{
    private Toy _entity;
    private ToyDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        Toy entity = ToyMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getStatus().getValue(), _dto._status );
        assertEquals( entity.getName(), _dto._name );
        assertEquals( entity.getRegisterDate().toString(), _dto._registerDate );
        assertEquals( entity.getCode(), _dto._code );
        assertEquals( entity.getWidth(), _dto._width );
        assertEquals( entity.getHeight(), _dto._height );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        ToyDTO dto = ToyMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._name, _entity.getName() );
        assertEquals( dto._registerDate, _entity.getRegisterDate().toString() );
        assertEquals( dto._code, _entity.getCode() );
        assertEquals( dto._width, _entity.getWidth() );
        assertEquals( dto._height, _entity.getHeight() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createToy();

        _entity.setId( 1 );
        _entity.setStatus( MasterStatus.ACTIVE );
        _entity.setName( "toy" );
        _entity.setRegisterDate( LocalDate.now() );
        _entity.setCode( "code" );
        _entity.setWidth( 10.5 );
        _entity.setHeight( 8.2 );
    }

    private void createDTO()
    {
        _dto = new ToyDTO();

        _dto._id = _entity.getId();
        _dto._status = _entity.getStatus().getValue();
        _dto._name = _entity.getName();
        _dto._registerDate = _entity.getRegisterDate().toString();
        _dto._code = _entity.getCode();
        _dto._width = _entity.getWidth();
        _dto._height = _entity.getHeight();
    }

}
