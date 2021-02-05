package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: Gender
 * Description: Entidad que define los posibles generos del usuario (Femenino, Masculino, etc)
 */
@Entity
@Table( name = "GENDER" )
public class Gender extends MasterEntity
{
    public Gender()
    {
    }

    public Gender( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Gender{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
