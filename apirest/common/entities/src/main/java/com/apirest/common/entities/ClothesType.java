package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ClothesType
 * Description: Entidad que define los tipos de ropa (Camiseta, Pantalones, Gorra)
 */

@Entity
@Table( name = "CLOTHESTYPE" )
public class ClothesType extends MasterEntity
{
    public ClothesType()
    {
    }

    public ClothesType( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ClothesType{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
