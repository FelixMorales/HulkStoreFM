package com.apirest.logic.dto;

public class ProductDTO
{
    public int _id;
    public String _name;
    public String _code;
    public String _registerDate;
    public int _status;
    public MasterDTO _hero;
    public MasterDTO _productType;
    public MasterDTO _brand;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ProductDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( "_name=" ).append( _name );
        sb.append( "_code=" ).append( _code );
        sb.append( "_registerDate=" ).append( _registerDate );
        sb.append( "_status=" ).append( _status );
        sb.append( "_hero=" ).append( _hero );
        sb.append( "_productType=" ).append( _productType );
        sb.append( "_brand=" ).append( _brand );
        sb.append( '}' );
        return sb.toString();
    }
}
