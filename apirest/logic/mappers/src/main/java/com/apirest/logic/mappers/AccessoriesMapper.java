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
        dto._hero = MasterMapper.mapEntityToDTO( entity.getHero() );
        dto._productType = MasterMapper.mapEntityToDTO( entity.getProductType() );
        dto._brand = MasterMapper.mapEntityToDTO( entity.getBrand() );

        dto._type = MasterMapper.mapEntityToDTO( entity.getType() );
        dto._materialType = MasterMapper.mapEntityToDTO( entity.getMaterialType() );


        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AccessoriesMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
