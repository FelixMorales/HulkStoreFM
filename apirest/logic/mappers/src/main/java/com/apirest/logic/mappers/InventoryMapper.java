package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.User;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.dto.InventoryDTO;
import com.apirest.logic.dto.UserDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InventoryMapper
{
    //private static Logger _logger = LoggerFactory.getLogger( InventoryMapper.class );

    public static Inventory mapDtoToEntity( InventoryDTO dto )
    {
        final Inventory entity = EntityFactory.createInventory( );

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a InventoryMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( MasterStatus.valueOf( dto._status ) );
        entity.setQuantity( dto._quantity );
        entity.setQuantityAvailable( dto._quantityAvailable );
        entity.setUnitPrice( dto._unitPrice );

        if( dto._registerDate != null )
            entity.setRegisterDate( LocalDateTime.parse( dto._registerDate ) );

        if( dto._supplyDate != null )
            entity.setSupplyDate( LocalDateTime.parse( dto._supplyDate ) );

        if ( dto._product != null )
            entity.setProduct( ProductMapper.mapDtoToEntity( dto._product ) );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de InventoryMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static InventoryDTO mapEntityToDto( Inventory entity )
    {
        final InventoryDTO dto = new InventoryDTO();

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a InventoryMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._product = ProductMapper.mapEntityToDto( entity.getProduct() );
        dto._registerDate = entity.getRegisterDate().toString();
        dto._supplyDate = entity.getSupplyDate().toString();
        dto._quantity = entity.getQuantity();
        dto._quantityAvailable = entity.getQuantityAvailable();
        dto._status = entity.getStatus().getValue();
        dto._unitPrice = entity.getUnitPrice();

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de InventoryMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
