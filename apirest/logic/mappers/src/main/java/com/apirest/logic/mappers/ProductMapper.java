package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.Product;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ProductMapper.class );

    public static Product mapDtoToEntity( ProductDTO dto )
    {
        final Product entity = EntityFactory.createProduct( );

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ProductMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setCode( dto._code );
        entity.setName( dto._name );
        entity.setStatus( MasterStatus.valueOf( dto._status ) );

        if ( dto._registerDate != null )
            entity.setRegisterDate( LocalDate.parse( dto._registerDate ) );

        if ( dto._hero != null )
            entity.setHero( EntityFactory.createHero( dto._hero._id ) );

        if ( dto._productType != null )
            entity.setProductType( EntityFactory.createProductType( dto._productType._id ) );

        if ( dto._brand != null )
            entity.setBrand( EntityFactory.createBrand(dto._brand._id) );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ProductMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ProductDTO mapEntityToDto( Product entity )
    {
        final ProductDTO dto = new ProductDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a ProductMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._name = entity.getName();
        dto._status = entity.getStatus().getValue();
        dto._registerDate = entity.getRegisterDate().toString();
        dto._code = entity.getCode();

        if (entity.getHero() != null)
            dto._hero = MasterMapper.mapEntityToDTO( entity.getHero() );

        if (entity.getProductType() != null)
            dto._productType = MasterMapper.mapEntityToDTO( entity.getProductType() );

        if(entity.getBrand() != null)
            dto._brand = MasterMapper.mapEntityToDTO( entity.getBrand() );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de ProductMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<ProductDTO> mapEntityListToDTOList( List<Product> entityList )
    {
        final List<ProductDTO> dtoList = new ArrayList<>();

        //region Instrumentation DEBUG
        _logger.debug( "entrando a ProductMapper.mapEntityListToDTOList: size {}, lista {}",
                       entityList.size(), entityList );
        //endregion

        for ( Product entity : entityList )
            dtoList.add( mapEntityToDto( entity ) );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de ProductMapper.mapEntityListToDTOList: size {}, lista {}",
                       dtoList.size(), dtoList );
        //endregion

        return dtoList;
    }
}
