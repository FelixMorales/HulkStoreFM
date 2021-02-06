package com.apirest.persistence.dao;

import com.apirest.common.entities.UtensilType;
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

public class UtensilTypeDAO extends BaseDAO<UtensilType>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public UtensilTypeDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de tipos de juguetes activos
     *
     * @return Lista de objeto ToyType
     */
    public List<UtensilType> findActives( )
    {
        List<UtensilType> result;

        //region Instrumentation
        //_logger.debug( "Entrando a ToyTypeDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<UtensilType> query = _builder.createQuery( UtensilType.class );
            Root<UtensilType> root = query.from( UtensilType.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( NoResultException e )
        {
            throw new NotFoundException( e, e.getMessage() );
        }
        catch ( Exception e )
        {
            throw new FindException( e, e.getMessage() );
        }

        //region Instrumentation
        //_logger.debug( "Saliendo de ToyTypeDAO.findActives result {}", result );
        //endregion

        return result;
    }

}