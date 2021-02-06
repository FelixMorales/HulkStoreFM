package com.apirest.persistence.dao;

import com.apirest.common.entities.UtensilType;
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

public class UtensilTypeDAO extends BaseDAO<UtensilType>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    private static Logger _logger = LoggerFactory.getLogger( UtensilTypeDAO.class );

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
        _logger.debug( "Entrando a ToyTypeDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<UtensilType> query = _builder.createQuery( UtensilType.class );
            Root<UtensilType> root = query.from( UtensilType.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_status" ), MasterStatus.ACTIVE ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        _logger.debug( "Saliendo de ToyTypeDAO.findActives result {}", result );
        //endregion

        return result;
    }

}
