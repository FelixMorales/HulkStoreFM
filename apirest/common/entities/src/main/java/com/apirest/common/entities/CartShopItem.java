package com.apirest.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Name: Gender
 * Description: Entidad que define el Carrito de Compra de los usuarios.
 */
@Entity
@Table( name = "CARTSHOPITEM", uniqueConstraints={
        @UniqueConstraint(columnNames = {"idProduct", "idUser"} ) } )
public class CartShopItem extends BaseEntity
{
    @ManyToOne
    @JoinColumn( name = "idProduct", nullable = false  )
    private Product _product;

    @ManyToOne
    @JoinColumn( name = "idUser", nullable = false  )
    private User _user;

    @Column( name = "quantity", nullable = false)
    private int _quantity;

    @Column( name = "registerDate", nullable = false)
    private LocalDate _registerDate;

    public Product getProduct()
    {
        return _product;
    }

    public void setProduct( Product product )
    {
        _product = product;
    }

    public User getUser()
    {
        return _user;
    }

    public void setUser( User user )
    {
        _user = user;
    }

    public int getQuantity()
    {
        return _quantity;
    }

    public void setQuantity( int quantity )
    {
        _quantity = quantity;
    }

    public LocalDate getRegisterDate()
    {
        return _registerDate;
    }

    public void setRegisterDate( LocalDate registerDate )
    {
        _registerDate = registerDate;
    }

    public CartShopItem()
    {
    }

    public CartShopItem( int id )
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
        CartShopItem cartShopItems = ( CartShopItem ) o;
        return _quantity == cartShopItems._quantity && _product.equals( cartShopItems._product ) &&
               _user.equals( cartShopItems._user ) && _registerDate.equals( cartShopItems._registerDate );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _product, _user, _quantity, _registerDate );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "CartShopItem{" );
        sb.append( super.toString() );
        sb.append( ", _registerDate='" ).append( _registerDate );
        sb.append( ", _user='" ).append( _user );
        sb.append( ", _product='" ).append( _product );
        sb.append( ", _quantity='" ).append( _quantity );
        sb.append( '}' );
        return sb.toString();
    }
}
