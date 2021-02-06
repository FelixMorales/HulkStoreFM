package com.apirest.logic.dto;

public class InventoryDTO
{
    public int _id;
    public ProductDTO _product;
    public int _quantity;
    public int _quantityAvailable;
    public double _unitPrice;
    public int _status;
    public String _registerDate;
    public String _supplyDate;


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "UserDto{" );
        sb.append( "_id=" ).append( _id );
        sb.append( "_product=" ).append( _product );
        sb.append( "_quantity=" ).append( _quantity );
        sb.append( "_quantityAvailable=" ).append( _quantityAvailable );
        sb.append( "_registerDate=" ).append( _registerDate );
        sb.append( "_status=" ).append( _status );
        sb.append( "_unitPrice" ).append( _unitPrice );
        sb.append( "_supplyDate" ).append( _supplyDate );
        sb.append( "_registerDate=" ).append( _registerDate );
        sb.append( '}' );
        return sb.toString();
    }
}
