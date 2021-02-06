package com.apirest.persistence.dao;

import com.apirest.common.entities.Gender;
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

public class GenderDAO extends BaseDAO<Gender>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( GenderDAO.class );

    public GenderDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de generos activos
     *
     * @return Lista de objeto Gender
     */
    public List<Gender> findActives( )
    {
        List<Gender> result;

        //region Instrumentation
        _logger.debug( "Entrando a GenderDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<Gender> query = _builder.createQuery( Gender.class );
            Root<Gender> root = query.from( Gender.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de GenderDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
