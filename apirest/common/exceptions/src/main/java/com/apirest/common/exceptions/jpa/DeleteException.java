package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: DeleteException
 * Description: Excepcion que se genera debido a un error inesperado al eliminar una entidad en la base de datos
 */
public class DeleteException extends BaseException
{
    public DeleteException( Exception e, String str )
    {
        super( e, str );
    }
}
