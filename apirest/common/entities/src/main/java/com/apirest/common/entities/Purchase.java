package com.apirest.common.entities;

import com.apirest.enums.PurchaseStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define la compra realizada por un usuario
 */
@Entity
@Table( name = "PURCHASE" )
public class Purchase extends BaseEntity
{
    @ManyToOne
    @JoinColumn( name = "idUser", nullable = false  )
    private User _user;

    @Column( name = "purchaseDate", nullable = false)
    private LocalDate _purchaseDate;

    @Column( name = "grossPrice", nullable = false )
    private double _grossPrice;

    @Column( name = "netPrice", nullable = false )
    private double _netPrice;

    @Column( name = "tax" )
    private double _tax;

    @Enumerated
    @Column( name = "status", nullable = false )
    private PurchaseStatus _status;

    @OneToMany( mappedBy = "_purchase", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<PurchaseDetail> _purchaseDetailList;

    public User getUser()
    {
        return _user;
    }

    public void setUser( User user )
    {
        _user = user;
    }

    public LocalDate getPurchaseDate()
    {
        return _purchaseDate;
    }

    public void setPurchaseDate( LocalDate purchaseDate )
    {
        _purchaseDate = purchaseDate;
    }

    public double getGrossPrice()
    {
        return _grossPrice;
    }

    public void setGrossPrice( double grossPrice )
    {
        _grossPrice = grossPrice;
    }

    public double getNetPrice()
    {
        return _netPrice;
    }

    public void setNetPrice( double netPrice )
    {
        _netPrice = netPrice;
    }

    public double getTax()
    {
        return _tax;
    }

    public void setTax( double tax )
    {
        _tax = tax;
    }

    public PurchaseStatus getStatus()
    {
        return _status;
    }

    public void setStatus( PurchaseStatus status )
    {
        _status = status;
    }

    public Purchase()
    {
    }

    public Purchase( int id )
    {
        super( id );
    }

    public List<PurchaseDetail> getPurchaseDetailList()
    {
        return _purchaseDetailList;
    }

    public void setPurchaseDetailList( List<PurchaseDetail> purchaseDetailList )
    {
        _purchaseDetailList = purchaseDetailList;
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
        Purchase purchase = ( Purchase ) o;
        return Double.compare( purchase._grossPrice, _grossPrice ) == 0 &&
               Double.compare( purchase._netPrice, _netPrice ) == 0 &&
               Double.compare( purchase._tax, _tax ) == 0 &&
               _user.equals( purchase._user ) && _purchaseDate.equals( purchase._purchaseDate ) &&
               _status == purchase._status;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _user, _purchaseDate, _grossPrice, _netPrice, _tax, _status );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Purchase{" );
        sb.append( super.toString() );
        sb.append( ", _user='" ).append( _user );
        sb.append( ", _grossPrice='" ).append( _grossPrice );
        sb.append( ", _tax='" ).append( _tax );
        sb.append( ", _netPrice='" ).append( _netPrice );
        sb.append( ", _status='" ).append( _status );
        sb.append( ", _purchaseDate='" ).append( _purchaseDate );
        sb.append( '}' );
        return sb.toString();
    }
}
