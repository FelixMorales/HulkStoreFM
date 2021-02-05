package com.apirest.services.implementation;

import com.apirest.common.entities.Gender;
import com.apirest.logic.commands.Command;
import com.apirest.logic.commands.misc.GetGendersCommand;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/misc" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class MiscService extends BaseApplicationService
{

    @GET
    @Path("/getGenders")
    public String getGenders(@Context HttpServletRequest request)
    {
        List<Gender> genders = null;
        try
        {
            Command<List<Gender>> command = new GetGendersCommand();
            command.execute();
            command.closeSession();

            genders = command.getReturnParam();
        }
        catch ( Exception e )
        {
            throw e;
        }

        StringBuilder names = new StringBuilder();

        for(Gender gender : genders)
        {
            names.append( gender.getValue() ).append( " " );
        }


        return names.toString();
    }
}
