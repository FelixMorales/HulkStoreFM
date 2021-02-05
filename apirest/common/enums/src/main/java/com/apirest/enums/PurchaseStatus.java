package com.apirest.enums;

import java.util.HashMap;

/**
 * Name: PurchaseStatus
 * Description: Contiene los estados de de una compra (PurchaseEntity)
 *
 * PENDING: Compra pendiente.
 * DONE: Compra finalizada exitosamente.
 * CANCELLED: Compra cancelada.
 */
public enum PurchaseStatus
{
    UNDEFINED( 0 ),
    PENDING( 1 ),
    DONE( 2 ),
    CANCELLED( 3 );

    private int _value;
    private static HashMap<Integer, PurchaseStatus> _map = new HashMap<>();

    PurchaseStatus( int value )
    {
        _value = value;
    }

    static
    {
        for( PurchaseStatus type : PurchaseStatus.values() )
        {
            _map.put( type._value, type );
        }
    }

    public static PurchaseStatus valueOf( int typeNum )
    {
        PurchaseStatus response = _map.get( typeNum );

        if( response == null )
            throw new IllegalArgumentException( "No enum constant was found for value: " + typeNum );

        return response;
    }

    public int getValue()
    {
        return _value;
    }
}
