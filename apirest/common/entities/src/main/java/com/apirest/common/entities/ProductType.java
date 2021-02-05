package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define los tipos de productos (Ropa, Comics, Utensilio, Juguetes, Accesorios)
 */

@Entity
@Table( name = "PRODUCTTYPE" )
public class ProductType extends MasterEntity
{
    public ProductType()
    {
    }

    public ProductType( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ProductType{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
