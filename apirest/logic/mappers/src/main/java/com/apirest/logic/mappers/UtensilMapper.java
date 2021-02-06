package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Utensil;
import com.apirest.logic.dto.UtensilDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtensilMapper
{
    private static Logger _logger = LoggerFactory.getLogger( UtensilMapper.class );

    public static Utensil mapDtoToEntity( UtensilDTO dto )
    {
        final Utensil entity = EntityFactory.createUtensil( ProductMapper.mapDtoToEntity( dto ) );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a UtensilMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        if( dto._type != null )
            entity.setType( EntityFactory.createUtensilType( dto._type._id ) );

        if ( dto._materialType != null )
            entity.setMaterialType( EntityFactory.createMaterialType( dto._materialType._id ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de UtensilMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UtensilDTO mapEntityToDto( Utensil entity )
    {
        final UtensilDTO dto = new UtensilDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a UtensilMapper.mapEntityToDto: entity {}", entity );
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
        _logger.debug( "Saliendo de UtensilMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
