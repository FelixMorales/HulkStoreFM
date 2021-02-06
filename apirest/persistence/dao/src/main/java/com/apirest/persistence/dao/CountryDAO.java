package com.apirest.persistence.dao;

import com.apirest.common.entities.Country;
import com.apirest.common.exceptions.jpa.FindAllException;
import com.apirest.common.exceptions.jpa.FindException;
import com.apirest.common.exceptions.jpa.NotFoundException;
import com.apirest.enums.MasterStatus;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CountryDAO extends BaseDAO<Country>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public CountryDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de paises activos
     *
     * @return Lista de objeto Gender
     */
    public List<Country> findActives( )
    {
        List<Country> result;

        //region Instrumentation
        //_logger.debug( "Entrando a CountryDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<Country> query = _builder.createQuery( Country.class );
            Root<Country> root = query.from( Country.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        //_logger.debug( "Saliendo de CountryDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
