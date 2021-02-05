package com.apirest.common.entities;

import com.apirest.enums.MasterStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define las características comunes de todos los productos.
 */
@Entity
@Table( name = "PRODUCT" )
@Inheritance( strategy = InheritanceType.JOINED )
public class Product extends BaseEntity
{
    @Column( name = "name", nullable = false )
    private String _name;

    @Column( name = "code", nullable = false )
    private String _code;

    @Column( name = "registerdate", nullable = false )
    private LocalDate _registerDate;

    @ManyToOne
    @JoinColumn( name = "idHero", nullable = false )
    private Hero _hero;

    @ManyToOne
    @JoinColumn( name = "idProductType", nullable = false )
    private ProductType _productType;

    @ManyToOne
    @JoinColumn( name = "idBrand", nullable = false )
    private Brand _brand;

    @Enumerated
    @Column( name = "status", nullable = false )
    private MasterStatus _status;

    public String getName()
    {
        return _name;
    }

    public void setName( String name )
    {
        _name = name;
    }

    public String getCode()
    {
        return _code;
    }

    public void setCode( String code )
    {
        _code = code;
    }

    public LocalDate getRegisterDate()
    {
        return _registerDate;
    }

    public void setRegisterDate( LocalDate registerDate )
    {
        _registerDate = registerDate;
    }

    public Hero getHero()
    {
        return _hero;
    }

    public void setHero( Hero hero )
    {
        _hero = hero;
    }

    public ProductType getProductType()
    {
        return _productType;
    }

    public void setProductType( ProductType productType )
    {
        _productType = productType;
    }

    public MasterStatus getStatus()
    {
        return _status;
    }

    public void setStatus( MasterStatus status )
    {
        _status = status;
    }

    public Brand getBrand()
    {
        return _brand;
    }

    public void setBrand( Brand brand )
    {
        _brand = brand;
    }

    public Product()
    {
    }

    public Product( int id )
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
        Product product = ( Product ) o;
        return _name.equals( product._name ) && _code.equals( product._code ) &&
               _registerDate.equals( product._registerDate ) && _hero.equals( product._hero ) &&
               _productType.equals( product._productType ) && _brand.equals( product._brand ) &&
               _status == product._status;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _name, _code, _registerDate, _hero, _productType, _brand, _status );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Product{" );
        sb.append( super.toString() );
        sb.append( ", _name='" ).append( _name );
        sb.append( ", _code='" ).append( _code );
        sb.append( ", _registerDate='" ).append( _registerDate );
        sb.append( ", _hero='" ).append( _hero );
        sb.append( ", _productType='" ).append( _productType );
        sb.append( ", _brand='" ).append( _brand );
        sb.append( ", _status='" ).append( _status );
        sb.append( '}' );
        return sb.toString();
    }
}
