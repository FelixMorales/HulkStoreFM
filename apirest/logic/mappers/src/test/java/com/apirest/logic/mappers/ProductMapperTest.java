package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Product;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest
{
    private Product _entity;
    private ProductDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        Product entity = ProductMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getStatus().getValue(), _dto._status );
        assertEquals( entity.getName(), _dto._name );
        assertEquals( entity.getRegisterDate().toString(), _dto._registerDate );
        assertEquals( entity.getCode(), _dto._code );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        ProductDTO dto = ProductMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._name, _entity.getName() );
        assertEquals( dto._registerDate, _entity.getRegisterDate().toString() );
        assertEquals( dto._code, _entity.getCode() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createProduct();

        _entity.setId( 1 );
        _entity.setStatus( MasterStatus.ACTIVE );
        _entity.setName( "accesorio" );
        _entity.setRegisterDate( LocalDate.now() );
        _entity.setCode( "code" );
    }

    private void createDTO()
    {
        _dto = new ProductDTO();

        _dto._id = _entity.getId();
        _dto._status = _entity.getStatus().getValue();
        _dto._name = _entity.getName();
        _dto._registerDate = _entity.getRegisterDate().toString();
        _dto._code = _entity.getCode();
    }

}
