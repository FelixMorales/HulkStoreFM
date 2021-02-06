package com.apirest.common.exceptions.purchase;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: PasswordAlgorithmException
 * Description: Excepcion que se genera cuando se intenta comprar sin productos en el carrito.
 */
public class EmptyShopCartException extends BaseException
{
    public EmptyShopCartException(  )
    {

    }
}
