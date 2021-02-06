package com.apirest.logic.commands.product.atomic;

import com.apirest.common.entities.Clothes;
import com.apirest.enums.MasterStatus;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.dao.ClothesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado de agregar un producto de tipo ropa.
 */
public class AddClothesCommand extends Command<Boolean>
{
    private Clothes _clothes;
    private ClothesDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( AddClothesCommand.class );

    public AddClothesCommand( Clothes clothes )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a AddClothesCommand.CTOR: clothes {}", clothes );
        //endregion

        createSession( true );

        _clothes = clothes;
        _dao = DAOFactory.createClothesDAO( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de AddClothesCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AddClothesCommand.execute" );
        //endregion

        _clothes.setRegisterDate( LocalDate.now() );
        _clothes.setStatus( MasterStatus.ACTIVE );
        _dao.insert( _clothes );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AddClothesCommand.execute" );
        //endregion
    }

    @Override
    public Boolean getReturnParam()
    {
        return true;
    }
}
