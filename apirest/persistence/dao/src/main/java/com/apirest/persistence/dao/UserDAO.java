package com.apirest.persistence.dao;

import com.apirest.common.entities.User;
import com.apirest.common.exceptions.jpa.FindException;
import com.apirest.common.exceptions.jpa.NotFoundException;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAO extends BaseDAO<User>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public UserDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findByEmail
     * Description: Metodo que retorna el usuario encrontado por email
     *
     * @param user Username
     * @return UserPassword y User object
     */
    public User findByEmail( User user )
    {
        User result;

        //region Instrumentation
        //_logger.debug( "Entrando a UserDao.findByEmail user {}", user );
        //endregion

        try
        {
            CriteriaQuery<User> query = _builder.createQuery( User.class );
            Root<User> root = query.from( User.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_email" ), user.getEmail() ) );

            result = _em.createQuery( query ).getSingleResult();
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
        //_logger.debug( "Saliendo de UserDao.findByEmail result {}", result );
        //endregion

        return result;
    }

}
