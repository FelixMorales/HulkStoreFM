package com.apirest.common.utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class JWT
{
    private static SecretKey _secretKey;
    private static String _issuer = Registry.getInstance().getProperty( Registry.JWT_ISSUER );
    private static String _algorithm = Registry.getInstance().getProperty( Registry.JWT_ALGORITHM );
    private static int _expiration = Integer.parseInt( Registry.getInstance().getProperty( Registry.JWT_EXPIRATION ) );

    //private static Logger _logger = LoggerFactory.getLogger( JWT.class );

    static
    {
        setKey();
    }

    private static void setKey()
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a JWT.setKey" );
        //endregion

        try
        {
            _secretKey = Keys.secretKeyFor( SignatureAlgorithm.forName( _algorithm ) );
        }
        catch( Exception e )
        {
            throw e;
            //throw new JWTSetKeyException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de JWT.setKey" );
        //endregion
    }

    /**
     * Name: createToken
     * Description: Metodo que crea un token JWT en base al subject (see RFC 7519)
     *
     * @param subject Subject del JWT (User ID)
     * @return Token JWT
     */
    public static String createToken( String subject )
    {
        String result = null;

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a JWT.createToken: subject {}", subject );
        //endregion

        try
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime( new Date(  ) );
            calendar.add( Calendar.MILLISECOND, _expiration );

            result = Jwts.builder()
                    .setIssuer( _issuer )
                    .setSubject( subject )
                    .setExpiration( calendar.getTime() )
                    .setNotBefore( new Date(  ) )
                    .setIssuedAt( new Date(  ) )
                    .setId( UUID.randomUUID().toString() )
                    .signWith( _secretKey, SignatureAlgorithm.forName( _algorithm ) )
                    .compact();
        }
        catch ( Exception e )
        {
            throw e;
            //throw new JWTCreateException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de JWT.createToken: token {}", result );
        //endregion

        return result;
    }

    /**
     * Name: verifyToken
     * Description: Metodo que valida si el token JWT es valido
     *
     * @param token Token JWT
     * @param subject Subject del JWT (User ID)
     */
    public static void verifyToken( String token, String subject )
    {
        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a JWT.verifyToken: token {}, subject {}", token, subject );
        //endregion

        try
        {
            Jwts.parser()
                    .requireSubject( subject )
                    .requireIssuer( _issuer )
                    .setSigningKey( _secretKey )
                    .parseClaimsJws( token );
        }
        catch ( Exception e )
        {
            //_logger.error( e.getMessage(), e );

            throw e;
            //throw new JWTVerifyException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de JWT.verifyToken" );
        //endregion
    }

    public static String verifyToken(String token )
    {
        String result = "";

        //region Instrumentation DEBUG
        //_logger.debug( "entrando a JWT.createToken: token {}", token );
        //endregion

        try
        {
            Jws<Claims> claims = Jwts.parser()
                    .requireIssuer( _issuer )
                    .setSigningKey( _secretKey )
                    .parseClaimsJws( token );

            result = claims.getBody().getSubject();
        }
        catch ( Exception e )
        {
            //_logger.error( e.getMessage(), e );

            throw e;
            //throw new JWTVerifyException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        //_logger.debug( "saliendo a JWT.createToken: result {}", result );
        //endregion

        return result;
    }
}
