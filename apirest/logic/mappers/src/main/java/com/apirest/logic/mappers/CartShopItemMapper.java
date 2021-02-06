package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.CartShopItem;
import com.apirest.logic.dto.CartShopItemDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartShopItemMapper
{
    //private static Logger _logger = LoggerFactory.getLogger( CartShopItemMapper.class );

    public static CartShopItem mapDtoToEntity( CartShopItemDTO dto )
    {
        final CartShopItem entity = EntityFactory.createCartShopItem( );

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a CartShopItemMapper.mapDtoToEntity: dto {}", dto );
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
        //_logger.debug( "Saliendo de CartShopItemMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static CartShopItemDTO mapEntityToDto( CartShopItem entity )
    {
        final CartShopItemDTO dto = new CartShopItemDTO();

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a CartShopItemMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._quantity = entity.getQuantity();
        dto._product = ProductMapper.mapEntityToDto( entity.getProduct() );
        dto._user = UserMapper.mapEntityToDto( entity.getUser() );
        dto._registerDate = entity.getRegisterDate().toString();

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de CartShopItemMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<CartShopItemDTO> mapEntityListToDTOList( List<CartShopItem> entityList )
    {
        final List<CartShopItemDTO> dtoList = new ArrayList<>();

        //region Instrumentation DEBUG
        //_logger.debug( "entrando a CartShopItemMapper.mapEntityListToDTOList: size {}, lista {}",
        //               entityList.size(), entityList );
        //endregion

        for ( CartShopItem entity : entityList )
            dtoList.add( mapEntityToDto( entity ) );

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo de CartShopItemMapper.mapEntityListToDTOList: size {}, lista {}",
        //               dtoList.size(), dtoList );
        //endregion

        return dtoList;
    }
}
