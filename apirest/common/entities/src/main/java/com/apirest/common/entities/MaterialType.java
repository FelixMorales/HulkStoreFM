package com.apirest.common.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Name: ProductType
 * Description: Entidad que define los tipos de materiales de utensilios (Vidrio, Plastico, etc)
 */

@Entity
@Table( name = "MATERIALTYPE" )
public class MaterialType extends MasterEntity
{
    public MaterialType()
    {
    }

    public MaterialType( int id )
    {
        super( id );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "MaterialType{" );
        sb.append( super.toString() );
        sb.append( '}' );
        return sb.toString();
    }
}
