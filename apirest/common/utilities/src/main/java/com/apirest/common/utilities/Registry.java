package com.apirest.common.utilities;

import com.apirest.common.exceptions.registry.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class Registry
{
    static final String JWT_SECRET = "jwt.secret";
    static final String JWT_ISSUER = "jwt.issuer";
    static final String JWT_EXPIRATION = "jwt.expiration";

    public static final String SEC_SALT_LENGTH = "sec.saltLength";
    public static final String SEC_ENCRYPT_ALGORITHM = "sec.algorithm";

    private static final String PROPERTIES_FILE = "apirest.properties";

    private static Registry _instance;

    private Properties _properties;

    private static Logger _logger = LoggerFactory.getLogger( Registry.class );

    /**
     * Name: getProperty
     * Description: Retorna el valor asociado al nombre del atributo entrante o en su defecto null
     *
     * @param key Nombre del atributo
     * @return Valor del atributo
     */
    public String getProperty( String key )
    {
        return _properties.getProperty( key );
    }

    private Registry()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a Registry.CTOR" );
        //endregion

        try
        {
            _properties = new Properties();
            _properties.load( getClass().getClassLoader().getResourceAsStream( PROPERTIES_FILE ) );
        }
        catch( IOException e )
        {
            throw new ConfigException( e, "Error reading properties from " + PROPERTIES_FILE );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de Registry.CTOR: Properties {}", _properties );
        //endregion
    }

    /**
     * Name: getInstance
     * Description: Retorna una instancia creada o nueva de la clase Registry
     *
     * @return Retorna una instancia de la clase Registry
     */
    public static Registry getInstance()
    {
        if ( _instance == null )
            _instance = new Registry();

        return _instance;
    }
}
