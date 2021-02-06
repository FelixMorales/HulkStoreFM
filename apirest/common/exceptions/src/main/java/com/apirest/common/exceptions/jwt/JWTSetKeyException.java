package com.apirest.common.exceptions.jwt;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: JWTSetKeyException
 * Description: Excepcion que se genera al crear la clave secreta para firmar los tokens JWT
 */
public class JWTSetKeyException extends BaseException
{
    public JWTSetKeyException( Exception e, String str )
    {
        super( e, str );
    }
}
