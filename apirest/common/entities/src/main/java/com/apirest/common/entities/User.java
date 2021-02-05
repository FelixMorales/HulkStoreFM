package com.apirest.common.entities;

import com.apirest.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "USER" )
public class User extends BaseEntity
{
    @Column( name = "name", nullable = false )
    private String _name;

    @Column( name = "lastName", nullable = false )
    private String _lastName;

    @Column( name = "email", nullable = false, unique = true )
    private String _email;

    @Column( name = "password", nullable = false )
    private String _password;

    @Column( name = "registerdate", nullable = false )
    private LocalDate _registerDate;

    @ManyToOne
    @JoinColumn( name = "idGender", nullable = false )
    private Gender _gender;

    @ManyToOne
    @JoinColumn( name = "idCountry", nullable = false )
    private Country _country;

    @OneToMany( mappedBy = "_user" )
    private List<CartShopItems> _cartShopItems;

    @OneToMany( mappedBy = "_user" )
    private List<Purchase> _purchases;

    public List<CartShopItems> getCartShopItems()
    {
        return _cartShopItems;
    }

    public void setCartShopItems( List<CartShopItems> cartShopItems )
    {
        _cartShopItems = cartShopItems;
    }

    public String getName()
    {
        return _name;
    }

    public void setName( String name )
    {
        _name = name;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public void setLastName( String lastName )
    {
        _lastName = _lastName;
    }

    public String getEmail()
    {
        return _email;
    }

    public void setEmail( String email )
    {
        _email = email;
    }

    public Gender getGender()
    {
        return _gender;
    }

    public void setGender( Gender gender )
    {
        _gender = gender;
    }

    public Country getCountry()
    {
        return _country;
    }

    public void setCountry( Country country )
    {
        _country = country;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword( String password )
    {
        _password = password;
    }

    public LocalDate getRegisterDate()
    {
        return _registerDate;
    }

    public void setRegisterDate( LocalDate registerDate )
    {
        _registerDate = registerDate;
    }

    public List<Purchase> getPurchases()
    {
        return _purchases;
    }

    public void setPurchases( List<Purchase> purchases )
    {
        _purchases = purchases;
    }

    public User()
    {
    }

    public User( int id )
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
        User user = ( User ) o;
        return Objects.equals( _name, user._name ) && Objects.equals( _lastName, user._lastName ) &&
               Objects.equals( _registerDate, user._registerDate ) &&
               Objects.equals( _email, user._email ) &&
               Objects.equals( _gender, user._gender ) && Objects.equals( _country, user._country );
    }

    @Override
    public int hashCode()
    {
        return Objects
                .hash( super.hashCode(), _name, _lastName, _email, _gender, _country, _registerDate, _password );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "User{" );
        sb.append( super.toString());
        sb.append( ", _name='" ).append( _name );
        sb.append( ", _lastname='" ).append( _lastName );
        sb.append( ", _email='" ).append( _email );
        sb.append( ", _password='" ).append( _password );
        sb.append( ", _gender='" ).append( _gender );
        sb.append( ", _country='" ).append( _country );
        sb.append( ", _registerDate='" ).append( _registerDate );
        sb.append( '}' );
        return sb.toString();
    }
}
