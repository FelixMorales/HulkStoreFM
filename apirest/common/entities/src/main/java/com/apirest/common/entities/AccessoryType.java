package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define los tipos de accesorios (Lentes, Collares, Pulseras, etc)
 */

@Entity
@Table( name = "ACCESSORYTYPE" )
public class AccessoryType extends MasterEntity
{
    public AccessoryType()
    {
    }

    public AccessoryType( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "AccessoryType{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
