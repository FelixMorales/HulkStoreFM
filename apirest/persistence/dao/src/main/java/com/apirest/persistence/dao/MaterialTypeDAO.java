package com.apirest.persistence.dao;

import com.apirest.common.entities.MaterialType;
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

public class MaterialTypeDAO extends BaseDAO<MaterialType>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public MaterialTypeDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de tipos de materiales activos
     *
     * @return Lista de objeto MaterialType
     */
    public List<MaterialType> findActives( )
    {
        List<MaterialType> result;

        //region Instrumentation
        //_logger.debug( "Entrando a BrandDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<MaterialType> query = _builder.createQuery( MaterialType.class );
            Root<MaterialType> root = query.from( MaterialType.class );

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
        //_logger.debug( "Saliendo de BrandDAO.findActives result {}", result );
        //endregion

        return result;
    }

}