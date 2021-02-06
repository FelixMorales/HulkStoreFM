package com.apirest.persistence.dao;

import com.apirest.common.exceptions.jpa.AddException;
import com.apirest.common.exceptions.jpa.ConstraintException;
import com.apirest.common.exceptions.jpa.DeleteException;
import com.apirest.common.exceptions.jpa.DetachException;
import com.apirest.common.exceptions.jpa.FindAllException;
import com.apirest.common.exceptions.jpa.FindException;
import com.apirest.common.exceptions.jpa.UpdateException;
import com.apirest.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class BaseDAO<T>
{
    private Class<T> _class;
    private DBHandler _handler;

    private static Logger _logger = LoggerFactory.getLogger( BaseDAO.class );

    public BaseDAO( DBHandler handler )
    {
        _handler = handler;
        _class = (Class<T>) ( ( ParameterizedType ) getClass().getGenericSuperclass() ).getActualTypeArguments()[ 0 ];
    }

    /**
     * Name: insert
     * Description: metodo para insertar un registro en la BD.
     *
     * @param entity entity
     */
    public T insert( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.insert: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.persist( entity );
            em.flush();
        }
        catch ( PersistenceException | IllegalStateException e )
        {
            throw new ConstraintException( e, e.getMessage() );
        }
        catch ( Exception e )
        {
            throw new AddException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.insert: entity {}", entity );
        //endregion

        return entity;
    }

    /**
     * Name: update
     * Description: metodo para actualizar un registro en la BD
     *
     * @param entity entity
     */
    public T update( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.update: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.merge( entity );
            em.flush();
        }
        catch ( PersistenceException | IllegalStateException e )
        {
            throw new ConstraintException( e, e.getMessage() );
        }
        catch ( Exception e )
        {
            throw new UpdateException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.update: entity {}", entity );
        //endregion

        return entity;
    }

    /**
     * Name: delete
     * Description: metodo para eliminar un registro en la BD
     *
     * @param entity entity
     */
    public T delete( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.delete: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.remove( entity );
            em.flush();
        }
        catch ( Exception e )
        {
            throw new DeleteException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.delete: entity {}", entity );
        //endregion

        return entity;
    }

    /**
     * Name: findAll
     * Description: metodo para obtener todos los registros de una entidad.
     *
     * @return entity list
     */
    public List<T> findAll()
    {
        final CriteriaQuery<T> criteriaQuery;
        final Root<T> root;

        List<T> list = null;

        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.findAll: class {}", _class );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            criteriaQuery = em.getCriteriaBuilder().createQuery( _class );

            root = criteriaQuery.from( _class );
            criteriaQuery.select( root );

            list = em.createQuery( criteriaQuery ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.findAll: list {}", list );
        //endregion

        return list;
    }

    /**
     * Name: auth
     * Description: metodo para consultar la entidad en la BD
     *
     * @param id identifier
     */
    public T find( int id )
    {
        T result = null;

        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.find: id {} class {}", id, _class );
        //endregion

        try
        {
            result = _handler.getSession().find( _class, id );
        }
        catch ( Exception e )
        {
            throw new FindException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.find: entity {}", result );
        //endregion

        return result;
    }

    /**
     * Name: detach
     * Description: metodo para efecutar detach a la entidad.
     *
     * @param entity entity
     */
    public void detach( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.detach: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.detach( entity );
        }
        catch ( Exception e )
        {
            throw new DetachException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.detach" );
        //endregion
    }

    /**
     * Name: getDBHandler
     * Description: Obtener el Handler.
     *
     * @return handler
     */
    public DBHandler getDBHandler()
    {
        return _handler;
    }
}