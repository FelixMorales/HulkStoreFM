package com.apirest.services.implementation;

import com.apirest.common.entities.User;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.user.AddUserCommand;
import com.apirest.logic.commands.user.GetUsersCommand;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path( "/user" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserService extends BaseApplicationService
{

    @GET
    @Path("/testing")
    public String testing(@Context HttpServletRequest request)
    {
        try
        {
            Command command = new AddUserCommand();
            command.execute();
            command.closeSession();
        }
        catch ( Exception e )
        {
            throw e;
        }


        return "works";
    }

    @GET
    @Path("/getAll")
    public String getUsers(@Context HttpServletRequest request)
    {
        List<User> users = null;
        try
        {
            Command<List<User>> command = new GetUsersCommand();
            command.execute();
            command.closeSession();

            users = command.getReturnParam();
        }
        catch ( Exception e )
        {
            throw e;
        }

        StringBuilder names = new StringBuilder();

        for(User user : users)
        {
            names.append( user.getName() ).append( " " );
        }


        return names.toString();
    }
}
