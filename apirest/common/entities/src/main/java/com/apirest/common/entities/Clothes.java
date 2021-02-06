package com.apirest.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define los atributos especificos del tipo de producto Ropa.
 */
@Entity
@Table( name = "CLOTHES" )
public class Clothes extends Product
{
    @Column( name = "color")
    private String _color;

    @ManyToOne
    @JoinColumn( name = "idSize", nullable = false  )
    private ClothesSize _clothesSize;

    @ManyToOne
    @JoinColumn( name = "idType", nullable = false )
    private ClothesType _clothesType;

    public String getColor()
    {
        return _color;
    }

    public void setColor( String color )
    {
        _color = color;
    }

    public ClothesSize getClothesSize()
    {
        return _clothesSize;
    }

    public void setClothesSize( ClothesSize clothesSize )
    {
        _clothesSize = clothesSize;
    }

    public ClothesType getClothesType()
    {
        return _clothesType;
    }

    public void setClothesType( ClothesType clothesType )
    {
        _clothesType = clothesType;
    }

    public Clothes()
    {
    }

    public Clothes( int id )
    {
        super( id );
    }

    public Clothes( Product product )
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
        Clothes clothes = ( Clothes ) o;
        return Objects.equals( _color, clothes._color ) && _clothesSize.equals( clothes._clothesSize ) &&
               _clothesType.equals( clothes._clothesType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _color, _clothesSize, _clothesType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Clothes{" );
        sb.append( super.toString() );
        sb.append( ", _color='" ).append( _color );
        sb.append( ", _clothesSize='" ).append( _clothesSize );
        sb.append( ", _clothesType='" ).append( _clothesType );
        sb.append( '}' );
        return sb.toString();
    }
}
