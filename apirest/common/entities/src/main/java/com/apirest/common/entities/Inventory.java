package com.apirest.common.entities;

import com.apirest.common.BaseEntity;
import com.apirest.enums.MasterStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define el inventario de la tienda.
 */
@Entity
@Table( name = "INVENTORY" )
public class Inventory extends BaseEntity
{
    @ManyToOne
    @JoinColumn( name = "idProduct", nullable = false  )
    private Product _product;

    @Column( name = "quantity", nullable = false)
    private int _quantity;

    @Column( name = "unitPrice", nullable = false)
    private double _unitPrice;

    @Column( name = "quantityAvailable", nullable = false)
    private int _quantityAvailable;

    @Column( name = "registerDate", nullable = false)
    private LocalDate _registerDate;

    @Enumerated
    @Column( name = "status", nullable = false )
    private MasterStatus _status;

    public Product getProduct()
    {
        return _product;
    }

    public void setProduct( Product product )
    {
        _product = product;
    }

    public int getQuantity()
    {
        return _quantity;
    }

    public void setQuantity( int quantity )
    {
        _quantity = quantity;
    }

    public double getUnitPrice()
    {
        return _unitPrice;
    }

    public void setUnitPrice( double unitPrice )
    {
        _unitPrice = unitPrice;
    }

    public int getQuantityAvailable()
    {
        return _quantityAvailable;
    }

    public void setQuantityAvailable( int quantityAvailable )
    {
        _quantityAvailable = quantityAvailable;
    }

    public LocalDate getRegisterDate()
    {
        return _registerDate;
    }

    public void setRegisterDate( LocalDate registerDate )
    {
        _registerDate = registerDate;
    }

    public MasterStatus getStatus()
    {
        return _status;
    }

    public void setStatus( MasterStatus status )
    {
        _status = status;
    }

    public Inventory()
    {
    }

    public Inventory( int id )
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
        Inventory inventory = ( Inventory ) o;
        return _quantity == inventory._quantity && Double.compare( inventory._unitPrice, _unitPrice ) == 0 &&
               _quantityAvailable == inventory._quantityAvailable && _product.equals( inventory._product ) &&
               _registerDate.equals( inventory._registerDate ) && _status == inventory._status;
    }

    @Override
    public int hashCode()
    {
        return Objects
                .hash( super.hashCode(), _product, _quantity, _unitPrice, _quantityAvailable, _registerDate, _status );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Inventory{" );
        sb.append( super.toString() );
        sb.append( ", _unitPrice='" ).append( _unitPrice );
        sb.append( ", _product='" ).append( _product );
        sb.append( ", _quantity='" ).append( _quantity );
        sb.append( ", _quantityAvailable='" ).append( _quantityAvailable );
        sb.append( ", _status='" ).append( _status );
        sb.append( ", _registerDate='" ).append( _registerDate );
        sb.append( '}' );
        return sb.toString();
    }
}
