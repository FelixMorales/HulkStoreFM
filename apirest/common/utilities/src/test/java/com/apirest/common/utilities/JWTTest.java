package com.apirest.common.utilities;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.User;
import com.apirest.enums.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class JWTTest
{
    private User _user1;
    private User _user2;

    @BeforeEach
    public void setUp()
    {
        _user1 = EntityFactory.createUser();
        _user1.setId( 1 );
        _user1.setType( UserType.CLIENT );

        _user2 = EntityFactory.createUser();
        _user2.setId( 2 );
        _user2.setType( UserType.CLIENT );
    }

    @Test
    public  void verifyToken()
    {
        String tokenUser1 = generateToken( _user1 );
        String tokenUser2 = generateToken( _user2 );

        JWT.verifyToken( tokenUser1 );
        JWT.verifyToken( tokenUser2 );

        assertNotEquals(tokenUser1, tokenUser2);
    }

    private String generateToken( User user )
    {
        return JWT.createToken( String.valueOf( user.getType().getValue() ),
                                String.valueOf( user.getId() ) );
    }
}
