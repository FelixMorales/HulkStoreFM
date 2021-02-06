package com.apirest.common.exceptions.purchase;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: EmptyStockException
 * Description: Excepcion que se genera cuando el producto a comprar no se encuentra disponible en el inventario.
 */
public class EmptyStockException extends BaseException
{
    public EmptyStockException( )
    {

    }
}
