package com.apirest.common.entities;

import javax.persistence.Column;
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
@Table( name = "TOY" )
public class Toy extends Product
{
    @Column( name = "heigth" )
    private Double _height;

    @Column( name = "width" )
    private Double _width;

    @ManyToOne
    @JoinColumn( name = "idType", nullable = false )
    private ToyType _toyType;

    public Double getHeight()
    {
        return _height;
    }

    public void setHeight( Double height )
    {
        _height = height;
    }

    public Double getWidth()
    {
        return _width;
    }

    public void setWidth( Double width )
    {
        _width = width;
    }

    public ToyType getToyType()
    {
        return _toyType;
    }

    public void setToyType( ToyType toyType )
    {
        _toyType = toyType;
    }

    public Toy()
    {
    }

    public Toy( int id )
    {
        super( id );
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
        Toy toy = ( Toy ) o;
        return Objects.equals( _height, toy._height ) && Objects.equals( _width, toy._width ) &&
               _toyType.equals( toy._toyType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _height, _width, _toyType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Toy{" );
        sb.append( super.toString() );
        sb.append( ", _heigth='" ).append( _height );
        sb.append( ", _width='" ).append( _width );
        sb.append( ", _toyType='" ).append( _toyType );
        sb.append( '}' );
        return sb.toString();
    }
}
