package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define las marcas de los productos.
 */

@Entity
@Table( name = "BRAND" )
public class Brand extends MasterEntity
{
    public Brand()
    {
    }

    public Brand( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Brand{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
