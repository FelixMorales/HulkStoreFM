package com.apirest.logic.commands;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCommandsTest
{
    @Test
    public void AddUserClientCommandTest()
    {
        User user = EntityFactory.createUser();
        user.setEmail( "email@email.com" );
        user.setPassword( "123456" );
        user.setName( "Felix" );
        user.setLastName( "Morales" );
        user.setCountry( EntityFactory.createCountry( 1 ) );
        user.setGender( EntityFactory.createGender( 1 ) );

        Command command = CommandFactory.createAddUserClientCommand( user );
        command.execute();
        command.closeSession();

        assertTrue( user.getId() > 0 );
    }

    @Test
    public void AuthenticateUserCommand()
    {
        String email = "felix@email.com";
        String password = "123456-2123";

        User user = EntityFactory.createUser();
        user.setEmail( email);
        user.setPassword( password );
        user.setName( "Test" );
        user.setLastName( "Test-Test" );
        user.setCountry( EntityFactory.createCountry( 1 ) );
        user.setGender( EntityFactory.createGender( 1 ) );

        Command addUserClientCommand = CommandFactory.createAddUserClientCommand( user );
        addUserClientCommand.execute();
        addUserClientCommand.closeSession();

        user = EntityFactory.createUser();
        user.setEmail( email );
        user.setPassword( password );

        Command<User> authenticateUserCommand = CommandFactory.createAuthenticateUserCommand( user );
        authenticateUserCommand.execute();
        authenticateUserCommand.closeSession();

        assertFalse( authenticateUserCommand.getReturnParam().getToken().isEmpty() );
    }


}
