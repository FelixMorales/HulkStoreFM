package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define los tipos de utensilios (Vasos, Platos, Vasija, etc)
 */

@Entity
@Table( name = "UTENSILTYPE" )
public class UtensilType extends MasterEntity
{
    public UtensilType()
    {
    }

    public UtensilType( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "UtensilType{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
