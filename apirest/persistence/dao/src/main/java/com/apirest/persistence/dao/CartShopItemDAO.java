package com.apirest.persistence.dao;

import com.apirest.common.entities.CartShopItem;
import com.apirest.common.entities.User;
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

public class CartShopItemDAO extends BaseDAO<CartShopItem>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public CartShopItemDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Name: findByUser
     * Description: Metodo que retorna la lista de items del carrito de un usuario.
     *
     * @return Lista de objeto Hero
     */
    public List<CartShopItem> findByUser( User user )
    {
        List<CartShopItem> result;

        //region Instrumentation
        //_logger.debug( "Entrando a HeroDAO.findActives");
        //endregion

        try
        {
            CriteriaQuery<CartShopItem> query = _builder.createQuery( CartShopItem.class );
            Root<CartShopItem> root = query.from( CartShopItem.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_user" ), user.getId() ) );

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
