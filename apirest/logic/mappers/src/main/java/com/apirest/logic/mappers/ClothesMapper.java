package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Clothes;
import com.apirest.logic.dto.ClothesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClothesMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ClothesMapper.class );

    public static Clothes mapDtoToEntity( ClothesDTO dto )
    {
        final Clothes entity = EntityFactory.createClothes( ProductMapper.mapDtoToEntity( dto ) );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ClothesMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setColor( dto._color );

        if( dto._clothesSize != null )
            entity.setClothesSize( EntityFactory.createClothesSize( dto._clothesSize._id ) );

        if ( dto._clothesType != null )
            entity.setClothesType( EntityFactory.createClothesType( dto._clothesType._id ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ClothesMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ClothesDTO mapEntityToDto( Clothes entity )
    {
        final ClothesDTO dto = new ClothesDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ClothesMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._name = entity.getName();
        dto._status = entity.getStatus().getValue();
        dto._registerDate = entity.getRegisterDate().toString();
        dto._code = entity.getCode();
        dto._hero = MasterMapper.mapEntityToDTO( entity.getHero() );
        dto._productType = MasterMapper.mapEntityToDTO( entity.getProductType() );
        dto._brand = MasterMapper.mapEntityToDTO( entity.getBrand() );

        dto._color = entity.getColor();
        dto._clothesType = MasterMapper.mapEntityToDTO( entity.getClothesType() );
        dto._clothesSize = MasterMapper.mapEntityToDTO( entity.getClothesSize() );


        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ClothesMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
