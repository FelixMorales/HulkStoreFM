package com.apirest.persistence.dao;

import com.apirest.common.entities.Purchase;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class PurchaseDAO extends BaseDAO<Purchase>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public PurchaseDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
