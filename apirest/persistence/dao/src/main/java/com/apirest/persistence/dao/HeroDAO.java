package com.apirest.persistence.dao;

import com.apirest.common.entities.Hero;
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

public class HeroDAO extends BaseDAO<Hero>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public HeroDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de heroes activas
     *
     * @return Lista de objeto Hero
     */
    public List<Hero> findActives( )
    {
        List<Hero> result;

        //region Instrumentation
        //_logger.debug( "Entrando a HeroDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<Hero> query = _builder.createQuery( Hero.class );
            Root<Hero> root = query.from( Hero.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        //_logger.debug( "Saliendo de HeroDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
