package com.apirest.enums;

import java.util.HashMap;

/**
 * Name: MasterStatus
 * Description: Contiene los estados de las tablas (MasterEntity)
 *
 * INACTIVE: Registro inactivo para consultas.
 * ACTIVE: Registro activo para consultas.
 */
public enum MasterStatus
{
    INACTIVE( 0 ),
    ACTIVE( 1 );

    private int _value;
    private static HashMap<Integer, MasterStatus> _map = new HashMap<>();

    MasterStatus( int value )
    {
        _value = value;
    }

    static
    {
        for( MasterStatus type : MasterStatus.values() )
        {
            _map.put( type._value, type );
        }
    }

    public static MasterStatus valueOf( int typeNum )
    {
        MasterStatus response = _map.get( typeNum );

        if( response == null )
            throw new IllegalArgumentException( "No enum constant was found for value: " + typeNum );

        return response;
    }

    public int getValue()
    {
        return _value;
    }
}
