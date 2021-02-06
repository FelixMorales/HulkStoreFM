package com.apirest.logic.dto;

public class PurchaseDetailDTO
{
    public int _id;
    public InventoryDTO _inventory;
    public int _quantity;
    public double _unitPrice;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "PurchaseDetailDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( "_inventory=" ).append( _inventory );
        sb.append( "_quantity=" ).append( _quantity );
        sb.append( "_unitPrice=" ).append( _unitPrice );
        sb.append( '}' );
        return sb.toString();
    }
}
