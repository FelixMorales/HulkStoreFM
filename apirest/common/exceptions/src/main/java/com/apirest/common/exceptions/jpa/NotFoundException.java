package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: NotFoundException
 * Description: Excepcion que se genera cuando la consulta de una entidad (Criteria Query) no retorna un resultado
 */
public class NotFoundException extends BaseException
{
    public NotFoundException( Exception e, String str )
    {
        super( e, str );
    }
}
