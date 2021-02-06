package com.apirest.common.exceptions.jwt;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: JWTCreateException
 * Description: Excepcion que se genera al crear un token JWT
 */
public class JWTCreateException extends BaseException
{
    public JWTCreateException( Exception e, String str )
    {
        super( e, str );
    }
}
