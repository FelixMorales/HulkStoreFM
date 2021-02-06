package com.apirest.logic.dto;

public class CartShopItemDTO
{
    public int _id;
    public ProductDTO _product;
    public UserDTO _user;
    public int _quantity;
    public String _registerDate;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "CartShopItemDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( "_product=" ).append( _product );
        sb.append( "_user=" ).append( _user );
        sb.append( "_registerDate=" ).append( _registerDate );
        sb.append( "_quantity=" ).append( _quantity );
        sb.append( '}' );
        return sb.toString();
    }
}
