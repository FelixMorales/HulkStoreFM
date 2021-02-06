package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.MasterEntity;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.dto.MasterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MasterMapperTest
{
    private MasterEntity _entity;

    @BeforeEach
    public void setUp()
    {
        createEntity();
    }

    @Test
    public void mapEntityToDtoTest()
    {
        MasterDTO dto = MasterMapper.mapEntityToDTO( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._value, _entity.getValue()  );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createProductType();

        _entity.setId( 1 );
        _entity.setStatus( MasterStatus.ACTIVE );
        _entity.setValue( "master" );
    }

}
