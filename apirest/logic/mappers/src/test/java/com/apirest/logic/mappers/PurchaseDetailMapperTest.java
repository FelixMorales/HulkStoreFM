package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.PurchaseDetail;
import com.apirest.logic.dto.PurchaseDetailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseDetailMapperTest
{
    private PurchaseDetail _entity;

    @BeforeEach
    public void setUp()
    {
        createEntity();
    }

    @Test
    public void mapEntityToDtoTest()
    {
        PurchaseDetailDTO dto = PurchaseDetailMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._unitPrice, _entity.getUnitPrice());
        assertEquals( dto._quantity, _entity.getQuantity()  );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createPurchaseDetail();

        _entity.setId( 1 );
        _entity.setUnitPrice( 10.50 );
        _entity.setQuantity( 4 );
    }

}
