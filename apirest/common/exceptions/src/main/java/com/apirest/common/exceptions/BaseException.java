package com.apirest.common.exceptions;

/**
 * Name: BaseException
 * Description: Excepcion generica
 */
public abstract class BaseException extends RuntimeException
{
    public BaseException()
    {
    }

    public BaseException( Exception e, String str )
    {
        super( str, e );
    }
}
