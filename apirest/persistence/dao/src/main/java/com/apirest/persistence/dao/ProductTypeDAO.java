package com.apirest.persistence.dao;

import com.apirest.common.entities.ProductType;
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

public class ProductTypeDAO extends BaseDAO<ProductType>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( ProductTypeDAO.class );

    public ProductTypeDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de tipos de productos activos
     *
     * @return Lista de objeto ProductType
     */
    public List<ProductType> findActives( )
    {
        List<ProductType> result;

        //region Instrumentation
        _logger.debug( "Entrando a ProductTypeDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<ProductType> query = _builder.createQuery( ProductType.class );
            Root<ProductType> root = query.from( ProductType.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de ProductTypeDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
