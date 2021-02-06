package com.apirest.persistence.dao;

import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.Product;
import com.apirest.common.exceptions.jpa.FindAllException;
import com.apirest.enums.MasterStatus;
import com.apirest.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class InventoryDAO extends BaseDAO<Inventory>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( InventoryDAO.class );

    public InventoryDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista productos disponibles en el inventario.
     *
     * @return Lista de objeto ToyType
     */
    public List<Inventory> findAvailableProductStock( Product product )
    {
        List<Inventory> result;

        //region Instrumentation
        _logger.debug( "Entrando a InventoryDAO.findAvailableProductStock product {}", product );
        //endregion

        try
        {
            CriteriaQuery<Inventory> query = _builder.createQuery( Inventory.class );
            Root<Inventory> root = query.from( Inventory.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ),
                         _builder.greaterThan( root.get( "_quantityAvailable" ), 0),
                         _builder.equal( root.get( "_product" ), product.getId() ) );

            query.orderBy( _builder.asc( root.get( "_supplyDate" ) ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de InventoryDAO.findAvailableProductStock result {}", result );
        //endregion

        return result;
    }

}
