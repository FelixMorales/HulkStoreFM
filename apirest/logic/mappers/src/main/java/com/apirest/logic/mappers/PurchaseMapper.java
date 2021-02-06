package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Purchase;
import com.apirest.enums.PurchaseStatus;
import com.apirest.logic.dto.PurchaseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;


public class PurchaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( PurchaseMapper.class );

    public static Purchase mapDtoToEntity( PurchaseDTO dto )
    {
        final Purchase entity = EntityFactory.createPurchase( );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a PurchaseMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( PurchaseStatus.valueOf( dto._status ) );
        entity.setNetPrice( dto._netPrice );
        entity.setGrossPrice( dto._grossPrice );
        entity.setTax( dto._tax );


        if( dto._purchaseDate != null )
            entity.setPurchaseDate( LocalDate.parse( dto._purchaseDate ) );

        if ( dto._user != null )
            entity.setUser( UserMapper.mapDtoToEntity( dto._user ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de PurchaseMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static PurchaseDTO mapEntityToDto( Purchase entity )
    {
        final PurchaseDTO dto = new PurchaseDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a PurchaseMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._purchaseDate = entity.getPurchaseDate().toString();
        dto._grossPrice = entity.getGrossPrice();
        dto._netPrice = entity.getNetPrice();
        dto._status = entity.getStatus().getValue();
        dto._tax = entity.getTax();
        dto._user = UserMapper.mapEntityToDto( entity.getUser() );

        if ( entity.getPurchaseDetailList() != null )
            dto._purchaseDetailList = PurchaseDetailMapper.mapEntityListToDTOList( entity.getPurchaseDetailList() );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de PurchaseMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
