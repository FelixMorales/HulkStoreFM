package com.apirest.common.utilities;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SecurityTest
{
    private User _user;
    private String _password;

    @BeforeEach
    public void setUp()
    {
        _password = "123456";

        _user = EntityFactory.createUser();

        String salt = Security.generateSalt();
        _user.setSalt( salt );
    }

    @Test
    public  void verifyHash()
    {
        _user.setPassword( Security.hashPassword( _password, _user.getSalt() ) );

        assertNotEquals( _password, _user.getPassword() );
    }
}
