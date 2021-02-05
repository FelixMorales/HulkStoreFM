package com.apirest.logic.commands;

import com.apirest.common.entities.User;
import com.apirest.logic.commands.user.atomic.AddUserClientCommand;
import com.apirest.logic.commands.user.atomic.AuthenticateUserCommand;

public class CommandFactory
{
    public static AddUserClientCommand createAddUserClientCommand( User user )
    {
        return new AddUserClientCommand( user );
    }

    public static AuthenticateUserCommand createAuthenticateUserCommand( User user )
    {
        return new AuthenticateUserCommand( user );
    }
}
