package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: FindException
 * Description: Excepcion que se genera debido a un error inesperado al consultar una entidad por su ID
 */
public class FindException extends BaseException
{
    public FindException( Exception e, String str )
    {
        super( e, str );
    }
}
