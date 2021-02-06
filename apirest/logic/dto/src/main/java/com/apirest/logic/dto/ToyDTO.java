package com.apirest.logic.dto;

public class ToyDTO extends ProductDTO
{
    public MasterDTO _type;
    public double _width;
    public double _height;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ToyDTO{" );
        sb.append( super.toString() );
        sb.append( "_type" ).append( _type );
        sb.append( "_width=" ).append( _width );
        sb.append( "_height=" ).append( _height );
        sb.append( '}' );
        return sb.toString();
    }
}
