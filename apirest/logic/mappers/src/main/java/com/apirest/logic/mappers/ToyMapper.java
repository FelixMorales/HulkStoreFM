package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Toy;
import com.apirest.logic.dto.ToyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToyMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ToyMapper.class );

    public static Toy mapDtoToEntity( ToyDTO dto )
    {
        final Toy entity = EntityFactory.createToy( ProductMapper.mapDtoToEntity( dto ) );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ToyMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setWidth( dto._width );
        entity.setHeight( dto._height );

        if( dto._type != null )
            entity.setToyType( EntityFactory.createToyType( dto._type._id ) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ToyMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ToyDTO mapEntityToDto( Toy entity )
    {
        final ToyDTO dto = new ToyDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ToyMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._name = entity.getName();
        dto._status = entity.getStatus().getValue();
        dto._registerDate = entity.getRegisterDate().toString();
        dto._code = entity.getCode();
        dto._hero = MasterMapper.mapEntityToDTO( entity.getHero() );
        dto._productType = MasterMapper.mapEntityToDTO( entity.getProductType() );
        dto._brand = MasterMapper.mapEntityToDTO( entity.getBrand() );

        dto._type = MasterMapper.mapEntityToDTO( entity.getToyType() );
        dto._height = entity.getHeight();
        dto._width = entity.getWidth();

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ToyMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
