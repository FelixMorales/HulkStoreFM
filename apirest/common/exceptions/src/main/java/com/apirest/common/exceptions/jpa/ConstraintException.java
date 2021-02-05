package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: ConstraintException
 * Description: Excepcion que se genera cuando ocurre un error al insertar o actualizar una entidad en la base de datos
 * debido a que no cumple una o mas restricciones definidas en la entidad (el username debe tener una long. max de 50)
 */
public class ConstraintException extends BaseException
{
    public ConstraintException( Exception e, String str )
    {
        super( e, str );
    }
}
