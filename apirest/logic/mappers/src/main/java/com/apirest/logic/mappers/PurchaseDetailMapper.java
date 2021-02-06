package com.apirest.logic.mappers;

import com.apirest.common.entities.PurchaseDetail;
import com.apirest.logic.dto.PurchaseDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ShopCartItemMapper.class );

    public static PurchaseDetailDTO mapEntityToDto( PurchaseDetail entity )
    {
        final PurchaseDetailDTO dto = new PurchaseDetailDTO();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a PurchaseDetailMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._quantity = entity.getQuantity();
        dto._unitPrice = entity.getUnitPrice();

        if(entity.getInventory() != null)
            dto._inventory = InventoryMapper.mapEntityToDto( entity.getInventory() );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de PurchaseDetailMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<PurchaseDetailDTO> mapEntityListToDTOList( List<PurchaseDetail> entityList )
    {
        final List<PurchaseDetailDTO> dtoList = new ArrayList<>();

        //region Instrumentation DEBUG
        _logger.debug( "entrando a PurchaseDetailMapper.mapEntityListToDTOList: size {}, lista {}",
                       entityList.size(), entityList );
        //endregion

        for ( PurchaseDetail entity : entityList )
            dtoList.add( mapEntityToDto( entity ) );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de PurchaseDetailMapper.mapEntityListToDTOList: size {}, lista {}",
                       dtoList.size(), dtoList );
        //endregion

        return dtoList;
    }
}
