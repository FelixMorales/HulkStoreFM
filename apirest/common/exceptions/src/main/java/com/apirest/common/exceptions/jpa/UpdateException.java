package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: UpdateException
 * Description: Excepcion que se genera debido a un error inesperado al actualizar una entidad en la base de datos
 */
public class UpdateException extends BaseException
{
    public UpdateException( Exception e, String str )
    {
        super( e, str );
    }
}
