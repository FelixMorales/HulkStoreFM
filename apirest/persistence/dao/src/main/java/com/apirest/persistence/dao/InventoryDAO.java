package com.apirest.persistence.dao;

import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.User;
import com.apirest.common.exceptions.jpa.FindException;
import com.apirest.common.exceptions.jpa.NotFoundException;
import com.apirest.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class InventoryDAO extends BaseDAO<Inventory>
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public InventoryDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
