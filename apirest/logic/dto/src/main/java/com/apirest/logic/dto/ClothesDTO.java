package com.apirest.logic.dto;

public class ClothesDTO extends ProductDTO
{
    public String _color;
    public MasterDTO _clothesSize;
    public MasterDTO _clothesType;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ClothesDTO{" );
        sb.append( super.toString() );
        sb.append( "_color" ).append( _color );
        sb.append( "_clothesSize=" ).append( _clothesSize );
        sb.append( "_clothesType=" ).append( _clothesType );
        sb.append( '}' );
        return sb.toString();
    }
}
