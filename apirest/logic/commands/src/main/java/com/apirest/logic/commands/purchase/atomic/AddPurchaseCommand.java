package com.apirest.logic.commands.purchase.atomic;

import com.apirest.common.entities.Purchase;
import com.apirest.logic.commands.Command;
import com.apirest.persistence.DAOFactory;
import com.apirest.persistence.DBHandler;
import com.apirest.persistence.dao.PurchaseDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Name: GetCartShopItemsByUser
 * Description: Comando encargado insertar la información de la compra realizada.
 */
public class AddPurchaseCommand extends Command<Purchase>
{
    private Purchase _entity;
    private PurchaseDAO _dao;

    private static Logger _logger = LoggerFactory.getLogger( AddPurchaseCommand.class );

    public AddPurchaseCommand( Purchase purchase, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a AddPurchaseCommand.CTOR: purchase {}", purchase );
        //endregion

        _entity = purchase;
        _dao = DAOFactory.createPurchaseDAO( handler );

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de AddPurchaseCommand.CTOR: _dao {}", _dao );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a AddPurchaseCommand.execute" );
        //endregion

        _dao.insert( _entity );

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de AddPurchaseCommand.execute" );
        //endregion
    }

    @Override
    public Purchase getReturnParam()
    {
        return _entity;
    }
}
