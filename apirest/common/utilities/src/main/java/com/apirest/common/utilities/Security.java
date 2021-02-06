package com.apirest.common.utilities;

import com.apirest.common.exceptions.security.PasswordAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * Name: Security
 * Description: Clase que contiene los metodos necesarios para generar el hash de las claves de usuario
 */
public class Security
{
    private static Logger _logger = LoggerFactory.getLogger( Security.class );
    private static int _saltLength = Integer.parseInt( Registry.getInstance().getProperty( Registry.SEC_SALT_LENGTH ) );

    /**
     * Name: hashPassword
     * Description: Metodo que genera el hash del texto entrante usando una funcion hash actualizada
     *
     * @param strToEncrypt Texto a convertir
     * @param salt Caracteres que actualizan la funcion hash (para evitar ataques de diccionario)
     * @return Hash del texto entrante
     */
    public static String hashPassword( String strToEncrypt, String salt )
    {
        final String response;

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a Security.hashPassword: strToEncrypt {}, salt {}", strToEncrypt, salt );
        //endregion

        try
        {
            StringBuilder builder = new StringBuilder(  );

            MessageDigest digest = MessageDigest.getInstance( Registry.
                    getInstance().getProperty( Registry.SEC_ENCRYPT_ALGORITHM ) );

            digest.update( salt.getBytes() );

            byte[] hashedPassword = digest.digest( strToEncrypt.getBytes( StandardCharsets.UTF_8 ) );

            for ( byte passwordByte : hashedPassword )
            {
                builder.append( String.format( "%02x", passwordByte ) );
            }

            response = builder.toString();
        }
        catch ( Exception e )
        {
            throw new PasswordAlgorithmException( e, e.toString() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de Security.hashPassword:: response {}", response );
        //endregion

        return response;
    }

    /**
     * Name: generateSalt
     * Description: Metodo que genera 16 bytes de manera aleatoria y los retorna formateado
     *
     * @return Retorna una serie de caracteres aleatorios
     */
    public static String generateSalt()
    {
        final String response;

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a Security.generateSalt" );
        //endregion

        byte[] salt = new byte[ _saltLength ];
        SecureRandom random = new SecureRandom(  );
        StringBuilder builder = new StringBuilder(  );

        random.nextBytes( salt );

        for ( byte saltByte : salt )
        {
            builder.append( String.format( "%02x", saltByte ) );
        }

        response = builder.toString();

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de Security.generateSalt" );
        //endregion

        return response;
    }
}