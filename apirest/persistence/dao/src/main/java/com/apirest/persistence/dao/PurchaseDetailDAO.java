package com.apirest.persistence.dao;

import com.apirest.common.entities.PurchaseDetail;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class PurchaseDetailDAO extends BaseDAO<PurchaseDetail>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public PurchaseDetailDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
