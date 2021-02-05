package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define las tallas de la ropa (XS, S, M, L, etc)
 */

@Entity
@Table( name = "CLOTHESSIZE" )
public class ClothesSize extends MasterEntity
{
    public ClothesSize()
    {
    }

    public ClothesSize( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ClothesSize{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
