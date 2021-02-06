package com.apirest.persistence.dao;

import com.apirest.common.entities.ShopCartItem;
import com.apirest.common.entities.User;
import com.apirest.common.exceptions.jpa.DeleteException;
import com.apirest.common.exceptions.jpa.FindAllException;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ShopCartItemDAO extends BaseDAO<ShopCartItem>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ShopCartItemDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findByUser
     * Description: Metodo que retorna la lista de items del carrito de un usuario.
     *
     * @param user
     * @return Lista de objeto ShopCartItem
     */
    public List<ShopCartItem> findByUser( User user )
    {
        List<ShopCartItem> result;

        //region Instrumentation
        //_logger.debug( "Entrando a ShopCartItemDAO.findByUser");
        //endregion

        try
        {
            CriteriaQuery<ShopCartItem> query = _builder.createQuery( ShopCartItem.class );
            Root<ShopCartItem> root = query.from( ShopCartItem.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_user" ), user.getId() ) );

            result = _em.createQuery( query ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation
        //_logger.debug( "Saliendo de ShopCartItemDAO.findByUser result {}", result );
        //endregion

        return result;
    }

    /**
     * Name: findByUser
     * Description: Metodo encargado de eliminar los items del carrito de compras del usuario
     *
     * @param user
     */
    public void clearItems( User user )
    {
        //region Instrumentation
        //_logger.debug( "Entrando a ShopCartItemDAO.clearItems");
        //endregion

        try
        {
            CriteriaDelete<ShopCartItem> query = _builder.createCriteriaDelete( ShopCartItem.class );
            Root<ShopCartItem> root = query.from( ShopCartItem.class );

            query.where( _builder.equal( root.get( "_user" ), user.getId() ) );

            _em.createQuery( query ).executeUpdate();
        }
        catch ( Exception e )
        {
            throw new DeleteException( e, e.getMessage() );
        }

        //region Instrumentation
        //_logger.debug( "Saliendo de ShopCartItemDAO.clearItems");
        //endregion
    }

}
