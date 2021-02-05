package com.apirest.common.entities;

import com.apirest.enums.MasterStatus;
import com.apirest.enums.PurchaseStatus;
import com.apirest.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

    @Column( name = "password", length = 512, nullable = false )
    private String _password;

    @Column( name = "SALT", length = 512 )
    private String _salt;

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

    @Enumerated
    @Column( name = "status", nullable = false )
    private MasterStatus _status;

    @Enumerated
    @Column( name = "type", nullable = false )
    private UserType _type;

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
        _lastName = lastName;
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

    public MasterStatus getStatus()
    {
        return _status;
    }

    public void setStatus( MasterStatus status )
    {
        _status = status;
    }

    public UserType getType()
    {
        return _type;
    }

    public void setType( UserType type )
    {
        _type = type;
    }

    public String getSalt()
    {
        return _salt;
    }

    public void setSalt( String salt )
    {
        _salt = salt;
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
        return _name.equals( user._name ) && _lastName.equals( user._lastName ) && _email.equals( user._email ) &&
               _password.equals( user._password ) && Objects.equals( _salt, user._salt ) &&
               _registerDate.equals( user._registerDate ) && _gender.equals( user._gender ) &&
               _country.equals( user._country ) && _status == user._status && _type == user._type;
    }

    @Override
    public int hashCode()
    {
        return Objects
                .hash( super.hashCode(), _name, _lastName, _email, _password, _salt, _registerDate, _gender, _country,
                       _status, _type );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "User{" );
        sb.append( super.toString());
        sb.append( ", _name='" ).append( _name );
        sb.append( ", _lastname='" ).append( _lastName );
        sb.append( ", _email='" ).append( _email );
        sb.append( ", _gender='" ).append( _gender );
        sb.append( ", _country='" ).append( _country );
        sb.append( ", _status='" ).append( _status );
        sb.append( ", _type='" ).append( _type );
        sb.append( ", _registerDate='" ).append( _registerDate );
        sb.append( '}' );
        return sb.toString();
    }
}
