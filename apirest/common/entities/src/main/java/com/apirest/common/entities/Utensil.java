package com.apirest.common.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define los atributos especificos del tipo de producto Juguete.
 */
@Entity
@Table( name = "UTENSIL" )
public class Utensil extends Product
{
    @ManyToOne
    @JoinColumn( name = "idType", nullable = false )
    private UtensilType _type;

    @ManyToOne
    @JoinColumn( name = "idMaterialType", nullable = false )
    private MaterialType _materialType;

    public UtensilType getType()
    {
        return _type;
    }

    public void setType( UtensilType type )
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

    public Utensil()
    {
    }

    public Utensil( int id )
    {
        super( id );
    }

    public Utensil( Product product ){
        super(product);
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
        Utensil utensil = ( Utensil ) o;
        return _type.equals( utensil._type ) && _materialType.equals( utensil._materialType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _type, _materialType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Utensil{" );
        sb.append( super.toString() );
        sb.append( ", _type='" ).append( _type );
        sb.append( ", _materialType='" ).append( _materialType );
        sb.append( '}' );
        return sb.toString();
    }
}
