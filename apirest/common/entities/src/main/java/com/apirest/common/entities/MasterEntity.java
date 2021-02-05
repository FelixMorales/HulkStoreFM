package com.apirest.common.entities;

import com.apirest.common.BaseEntity;
import com.apirest.enums.MasterStatus;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MasterEntity extends BaseEntity
{
    @Column( name = "description", nullable = false )
    private String _value;

    @Enumerated
    @Column( name = "status", nullable = false )
    private MasterStatus _status;

    public MasterStatus getStatus()
    {
        return _status;
    }

    public void setStatus( MasterStatus status )
    {
        _status = status;
    }

    public String getValue()
    {
        return _value;
    }

    public void setValue( String value )
    {
        _value = value;
    }

    public MasterEntity()
    {

    }

    public MasterEntity( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "MasterEntity{" );
        sb.append( super.toString() );
        sb.append( ", _value='" ).append( _value );
        sb.append( ", _status=" ).append( _status );
        sb.append( '}' );
        return sb.toString();
    }
}