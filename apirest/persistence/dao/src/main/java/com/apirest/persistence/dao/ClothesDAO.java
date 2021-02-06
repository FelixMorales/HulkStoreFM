package com.apirest.persistence.dao;

import com.apirest.common.entities.Product;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class ClothesDAO extends BaseDAO<Product>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ClothesDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
