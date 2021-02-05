package com.apirest.enums;

import java.util.HashMap;

/**
 * Name: PurchaseStatus
 * Description: Contiene los tipos de usuario
 *
 * CLIENT: Usuario tipo cliente.
 * ADMINISTRATOR: Usuario tipo administrador.
 */
public enum UserType
{
    UNDEFINED( 0 ),
    CLIENT( 1 ),
    ADMINISTRATOR( 2 );

    private int _value;
    private static HashMap<Integer, UserType> _map = new HashMap<>();

    UserType( int value )
    {
        _value = value;
    }

    static
    {
        for( UserType type : UserType.values() )
        {
            _map.put( type._value, type );
        }
    }

    public static UserType valueOf( int typeNum )
    {
        UserType response = _map.get( typeNum );

        if( response == null )
            throw new IllegalArgumentException( "No enum constant was found for value: " + typeNum );

        return response;
    }

    public int getValue()
    {
        return _value;
    }
}
