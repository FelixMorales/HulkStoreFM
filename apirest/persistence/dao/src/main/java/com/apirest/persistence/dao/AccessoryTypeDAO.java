package com.apirest.persistence.dao;

import com.apirest.common.entities.AccessoryType;
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

public class AccessoryTypeDAO extends BaseDAO<AccessoryType>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( AccessoryTypeDAO.class );

    public AccessoryTypeDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de tipos de accesorios activos
     *
     * @return Lista de objeto AccessoryType
     */
    public List<AccessoryType> findActives( )
    {
        List<AccessoryType> result;

        //region Instrumentation
        _logger.debug( "Entrando a AccessoryTypeDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<AccessoryType> query = _builder.createQuery( AccessoryType.class );
            Root<AccessoryType> root = query.from( AccessoryType.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de AccessoryTypeDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
