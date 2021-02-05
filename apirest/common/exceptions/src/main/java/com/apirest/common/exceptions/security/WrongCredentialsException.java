package com.apirest.common.exceptions.security;


import com.apirest.common.exceptions.BaseException;

/**
 * Name: WrongPasswordException
 * Description: Excepcion que se genera cuando las credenciales ingresadas por el usuario son incorrectas
 */
public class WrongCredentialsException extends BaseException
{
    public WrongCredentialsException()
    {
        super();
    }
}
