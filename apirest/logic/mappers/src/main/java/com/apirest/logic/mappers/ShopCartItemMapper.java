package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.ShopCartItem;
import com.apirest.logic.dto.ShopCartItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShopCartItemMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ShopCartItemMapper.class );

    public static ShopCartItem mapDtoToEntity( ShopCartItemDTO dto )
    {
        final ShopCartItem entity = EntityFactory.createShopCartItem( );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ShopCartItemMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setQuantity( dto._quantity );

        if(dto._product != null)
            entity.setProduct( ProductMapper.mapDtoToEntity( dto._product ) );

        if(dto._user != null)
            entity.setUser( UserMapper.mapDtoToEntity( dto._user )  );

        if(dto._registerDate != null )
            entity.setRegisterDate( LocalDate.parse( dto._registerDate ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ShopCartItemMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ShopCartItemDTO mapEntityToDto( ShopCartItem entity )
    {
        final ShopCartItemDTO dto = new ShopCartItemDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ShopCartItemMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._quantity = entity.getQuantity();
        dto._registerDate = entity.getRegisterDate().toString();

        if(entity.getProduct() != null)
            dto._product = ProductMapper.mapEntityToDto( entity.getProduct() );

        if(entity.getUser() != null)
            dto._user = UserMapper.mapEntityToDto( entity.getUser() );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ShopCartItemMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<ShopCartItemDTO> mapEntityListToDTOList( List<ShopCartItem> entityList )
    {
        final List<ShopCartItemDTO> dtoList = new ArrayList<>();

        //region Instrumentation DEBUG
        _logger.debug( "entrando a ShopCartItemMapper.mapEntityListToDTOList: size {}, lista {}",
                      entityList.size(), entityList );
        //endregion

        for ( ShopCartItem entity : entityList )
            dtoList.add( mapEntityToDto( entity ) );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de ShopCartItemMapper.mapEntityListToDTOList: size {}, lista {}",
                       dtoList.size(), dtoList );
        //endregion

        return dtoList;
    }
}
