package com.apirest.persistence.dao;

import com.apirest.common.entities.ClothesSize;
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

public class ClothesSizeDAO extends BaseDAO<ClothesSize>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ClothesSizeDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findActives
     * Description: Metodo que retorna la lista de tallas de ropa activas
     *
     * @return Lista de objeto ClothesSize
     */
    public List<ClothesSize> findActives( )
    {
        List<ClothesSize> result;

        //region Instrumentation
        //_logger.debug( "Entrando a ClothesSizeDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<ClothesSize> query = _builder.createQuery( ClothesSize.class );
            Root<ClothesSize> root = query.from( ClothesSize.class );

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
        //_logger.debug( "Saliendo de ClothesSizeDAO.findActives result {}", result );
        //endregion

        return result;
    }

}