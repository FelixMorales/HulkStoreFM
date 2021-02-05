package com.apirest.persistence.dao;

import com.apirest.common.entities.Gender;
import com.apirest.persistence.DBHandler;

public class GenderDAO extends BaseDAO<Gender>
{
    public GenderDAO( DBHandler handler )
    {
        super( handler );
    }

}
