package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define los tipos de juguetes (Bicicleta, Figura de accion, Carro, etc)
 */

@Entity
@Table( name = "TOYTYPE" )
public class ToyType extends MasterEntity
{
    public ToyType()
    {
    }

    public ToyType( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ToyType{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
