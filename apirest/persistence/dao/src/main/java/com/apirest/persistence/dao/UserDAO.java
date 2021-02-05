package com.apirest.persistence.dao;

import com.apirest.common.entities.User;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

    public List<User> find( )
    {
        List<User> result = null;

        try
        {
            CriteriaQuery<User> query = _builder.createQuery( User.class );
            Root<User> root = query.from( User.class );

            query.select( root );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( NoResultException e )
        {
            throw e;
            //throw new NotFoundException( e, e.getMessage() );
        }
        catch ( Exception e )
        {
            throw e;
            //throw new FindException( e, e.getMessage() );
        }

        return result;
    }

    public void addUser (User user)
    {
        insert( user );
    }
}
