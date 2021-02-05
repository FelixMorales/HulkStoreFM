package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: Hero
 * Description: Entidad que define los heroes (D.C, Marvel, Propios)
 */
@Entity
@Table( name = "HERO" )
public class Hero extends MasterEntity
{
    public Hero()
    {
    }

    public Hero( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Hero{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
