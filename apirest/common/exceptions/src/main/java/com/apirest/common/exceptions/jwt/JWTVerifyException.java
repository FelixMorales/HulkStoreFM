package com.apirest.common.exceptions.jwt;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: JWTVerifyException
 * Description: Excepcion que se genera al validar un token JWT
 */
public class JWTVerifyException extends BaseException
{
    public JWTVerifyException( Exception e, String str )
    {
        super( e, str );
    }
}
