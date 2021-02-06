package com.apirest.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define el detalle de una compra.
 */
@Entity
@Table( name = "PURCHASEDETAIL" )
public class PurchaseDetail extends BaseEntity
{
    @ManyToOne
    @JoinColumn( name = "idInventory", nullable = false  )
    private Inventory _inventory;

    @ManyToOne
    @JoinColumn( name = "idPurchase", nullable = false  )
    private Purchase _purchase;

    @Column( name = "quantity", nullable = false)
    private int _quantity;

    @Column( name = "unitPrice", nullable = false )
    private double _unitPrice;

    public Inventory getInventory()
    {
        return _inventory;
    }

    public void setInventory( Inventory inventory )
    {
        _inventory = inventory;
    }

    public Purchase getPurchase()
    {
        return _purchase;
    }

    public void setPurchase( Purchase purchase )
    {
        _purchase = purchase;
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

    public PurchaseDetail()
    {
    }

    public PurchaseDetail( int id )
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
        PurchaseDetail that = ( PurchaseDetail ) o;
        return _quantity == that._quantity && Double.compare( that._unitPrice, _unitPrice ) == 0 &&
               _inventory.equals( that._inventory ) && _purchase.equals( that._purchase );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _inventory, _purchase, _quantity, _unitPrice );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "PurchaseDetail{" );
        sb.append( super.toString() );
        sb.append( ", _inventory='" ).append( _inventory );
        sb.append( ", _purchase='" ).append( _purchase );
        sb.append( ", _quantity='" ).append( _quantity );
        sb.append( ", _unitPrice='" ).append( _unitPrice );
        sb.append( '}' );
        return sb.toString();
    }
}
