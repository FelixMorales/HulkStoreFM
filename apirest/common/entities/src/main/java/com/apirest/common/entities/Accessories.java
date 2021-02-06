package com.apirest.common.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define los atributos especificos del tipo de producto Accesorio.
 */
@Entity
@Table( name = "ACCESSORIES" )
public class Accessories extends Product
{
    @ManyToOne
    @JoinColumn( name = "idType" )
    private AccessoryType _type;

    @ManyToOne
    @JoinColumn( name = "idMaterialType" )
    private MaterialType _materialType;

    public AccessoryType getType()
    {
        return _type;
    }

    public void setType( AccessoryType type )
    {
        _type = type;
    }

    public MaterialType getMaterialType()
    {
        return _materialType;
    }

    public void setMaterialType( MaterialType materialType )
    {
        _materialType = materialType;
    }

    public Accessories()
    {
    }

    public Accessories( int id )
    {
        super( id );
    }

    public Accessories( Product product )
    {
        super( product );
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
        if ( !super.equals( o ) )
        {
            return false;
        }
        Accessories that = ( Accessories ) o;
        return Objects.equals( _type, that._type ) && Objects.equals( _materialType, that._materialType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _type, _materialType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Accessories{" );
        sb.append( super.toString() );
        sb.append( ", _type='" ).append( _type );
        sb.append( ", _materialType='" ).append( _materialType );
        sb.append( '}' );
        return sb.toString();
    }
}
