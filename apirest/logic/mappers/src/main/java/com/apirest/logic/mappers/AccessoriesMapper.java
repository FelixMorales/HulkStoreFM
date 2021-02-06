package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Accessories;
import com.apirest.logic.dto.AccessoriesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessoriesMapper
{
    private static Logger _logger = LoggerFactory.getLogger( AccessoriesMapper.class );

    public static Accessories mapDtoToEntity( AccessoriesDTO dto )
    {
        final Accessories entity = EntityFactory.createAccessories( ProductMapper.mapDtoToEntity( dto ) );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AccessoriesMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        if( dto._type != null )
            entity.setType( EntityFactory.createAccessoryTypes( dto._type._id ) );

        if ( dto._materialType != null )
            entity.setMaterialType( EntityFactory.createMaterialType( dto._materialType._id ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AccessoriesMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static AccessoriesDTO mapEntityToDto( Accessories entity )
    {
        final AccessoriesDTO dto = new AccessoriesDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AccessoriesMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._name = entity.getName();
        dto._status = entity.getStatus().getValue();
        dto._registerDate = entity.getRegisterDate().toString();
        dto._code = entity.getCode();

        if( entity.getBrand() != null)
            dto._brand = MasterMapper.mapEntityToDTO( entity.getBrand() );

        if( entity.getHero() != null )
            dto._hero = MasterMapper.mapEntityToDTO( entity.getHero() );

        if ( entity.getProductType() != null )
            dto._productType = MasterMapper.mapEntityToDTO( entity.getProductType() );

        if ( entity.getType() != null )
            dto._type = MasterMapper.mapEntityToDTO( entity.getType() );

        if ( entity.getMaterialType() != null )
            dto._materialType = MasterMapper.mapEntityToDTO( entity.getMaterialType() );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AccessoriesMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
