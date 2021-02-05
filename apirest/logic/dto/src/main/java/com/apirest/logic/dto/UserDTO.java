package com.apirest.logic.dto;

import java.util.List;

public class UserDTO
{
    public int _id;
    public String _name;
    public String _lastName;
    public String _email;
    public String _password;
    public String _salt;
    public String _registerDate;
    public int _status;
    public int _type;

    public MasterDTO _gender;
    public MasterDTO _country;

    //private List<CartShopItemsDTO> _cartShopItems;
    //private List<PurchaseDTO> _purchases;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "UserDto{" );
        sb.append( "_id=" ).append( _id );
        sb.append( "_name=" ).append( _name );
        sb.append( "_lastName=" ).append( _lastName );
        sb.append( "_email=" ).append( _email );
        sb.append( "_registerDate=" ).append( _registerDate );
        sb.append( "_status=" ).append( _status );
        sb.append( "_type=" ).append( _type );
        sb.append( "_gender=" ).append( _gender );
        sb.append( "_country=" ).append( _country );
        sb.append( '}' );
        return sb.toString();
    }
}
