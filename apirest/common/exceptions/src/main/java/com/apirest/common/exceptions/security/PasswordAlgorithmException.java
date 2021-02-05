package com.apirest.common.exceptions.security;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: PasswordAlgorithmException
 * Description: Excepcion que se genera cuando el algoritmo para realizar el hash de la clave es invalido o no existe
 */
public class PasswordAlgorithmException extends BaseException
{
    public PasswordAlgorithmException( Exception e, String str )
    {
        super( e, str );
    }
}
