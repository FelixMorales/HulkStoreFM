package com.apirest.logic.dto;

public class AccessoriesDTO extends ProductDTO
{
    public MasterDTO _type;
    public MasterDTO _materialType;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "AccessoriesDTO{" );
        sb.append( super.toString() );
        sb.append( "_type" ).append( _type );
        sb.append( "_materialType=" ).append( _materialType );
        sb.append( '}' );
        return sb.toString();
    }
}
