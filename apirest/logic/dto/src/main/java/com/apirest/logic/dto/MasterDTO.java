package com.apirest.logic.dto;

public class MasterDTO
{
    public int _id;
    public int _status;
    public String _value;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "MasterDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( ", _value='" ).append( _value );
        sb.append( ", _status=" ).append( _status );
        sb.append( '}' );
        return sb.toString();
    }
}
