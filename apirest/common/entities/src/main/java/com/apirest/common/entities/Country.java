package com.apirest.common.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: Gender
 * Description: Entidad que define el listado de paises (Venezuela, Colombia, etc)
 */
@Entity
@Table( name = "COUNTRY" )
public class Country extends MasterEntity
{
    public Country()
    {
    }

    public Country( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Country{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
