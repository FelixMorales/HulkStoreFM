package com.apirest.logic.dto;

import java.util.List;

public class PurchaseDTO
{
    public int _id;
    public UserDTO _user;
    public String _purchaseDate;
    public double _grossPrice;
    public double _netPrice;
    public double _tax;
    public int _status;
    public List<PurchaseDetailDTO> _purchaseDetailList;


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "PurchaseDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( "_user=" ).append( _user );
        sb.append( "_purchaseDate=" ).append( _purchaseDate );
        sb.append( "_grossPrice=" ).append( _grossPrice );
        sb.append( "_netPrice=" ).append( _netPrice );
        sb.append( "_tax=" ).append( _tax );
        sb.append( "_status=" ).append( _status );
        sb.append( '}' );
        return sb.toString();
    }
}
