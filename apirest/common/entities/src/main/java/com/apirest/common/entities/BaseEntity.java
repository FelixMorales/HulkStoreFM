package com.apirest.common.entities;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity
{
    @Id
    @Column( name = "id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;

    public BaseEntity() { }

    public BaseEntity( int id ) {
        _id = id;
    }

    public int getId()
    {
        return _id;
    }

    public void setId( int id )
    {
        _id = id;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        BaseEntity that = ( BaseEntity ) o;
        return _id == that._id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( _id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "BaseEntity{" );
        sb.append( "_id=" ).append( _id );
        sb.append( '}' );
        return sb.toString();
    }
}
