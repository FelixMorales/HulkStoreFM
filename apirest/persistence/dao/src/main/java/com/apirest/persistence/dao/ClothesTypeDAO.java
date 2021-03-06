package com.apirest.persistence.dao;

import com.apirest.common.entities.ClothesType;
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

public class ClothesTypeDAO extends BaseDAO<ClothesType>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( ClothesTypeDAO.class );

    public ClothesTypeDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de tipos de ropa activas
     *
     * @return Lista de objeto ClothesType
     */
    public List<ClothesType> findActives( )
    {
        List<ClothesType> result;

        //region Instrumentation
        _logger.debug( "Entrando a ClothesTypeDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<ClothesType> query = _builder.createQuery( ClothesType.class );
            Root<ClothesType> root = query.from( ClothesType.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de ClothesTypeDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
