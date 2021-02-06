package com.apirest.persistence.dao;

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

public class ProductDAO extends BaseDAO<Product>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( ProductDAO.class );

    public ProductDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de productos activas
     *
     * @return Lista de objeto Hero
     */
    public List<Product> findActives( )
    {
        List<Product> result;

        //region Instrumentation
        _logger.debug( "Entrando a ProductDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<Product> query = _builder.createQuery( Product.class );
            Root<Product> root = query.from( Product.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de ProductDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
