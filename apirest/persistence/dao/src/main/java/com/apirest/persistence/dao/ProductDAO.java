package com.apirest.persistence.dao;

import com.apirest.common.entities.Product;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class ProductDAO extends BaseDAO<Product>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ProductDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
