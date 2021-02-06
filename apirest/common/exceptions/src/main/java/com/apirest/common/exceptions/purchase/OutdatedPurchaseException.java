package com.apirest.common.exceptions.purchase;

import com.apirest.common.exceptions.BaseException;

/**
 * Name: OutdatedPurchaseException
 * Description: Excepcion que se genera cuando se intenta realizar una compra y la misma se encuentra desactualizada.
 * Ej: Se genera el detalle de compra para que el usuario pueda confirmar la misma antes de ejecutarla y al momento
 * de ejecutar la compra, la misma no tiene el mismo precio neto por cambios en el stock.
 */
public class OutdatedPurchaseException extends BaseException
{
    public OutdatedPurchaseException(  )
    {

    }
}
