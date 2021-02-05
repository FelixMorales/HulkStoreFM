package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: FindAllException
 * Description: Excepcion que se genera debido a un error inesperado al consultar la lista de entidades
 */
public class FindAllException extends BaseException
{
    public FindAllException( Exception e, String str )
    {
        super( e, str );
    }
}
