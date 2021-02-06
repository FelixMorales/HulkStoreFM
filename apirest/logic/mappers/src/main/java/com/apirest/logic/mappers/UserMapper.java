package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.User;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.dto.UserDTO;

import java.time.LocalDate;

public class UserMapper
{
    //private static Logger _logger = LoggerFactory.getLogger( UserMapper.class );

    public static User mapDtoToEntity( UserDTO dto )
    {
        final User entity = EntityFactory.createUser( );

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a UserMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setName( dto._name );
        entity.setLastName( dto._lastName );
        entity.setEmail( dto._email );
        entity.setPassword( dto._password );
        entity.setSalt( dto._salt );
        entity.setStatus( MasterStatus.valueOf( dto._status ) );
        entity.setType( UserType.valueOf( dto._type ) );
        entity.setToken( dto._token );

        if(dto._gender != null)
            entity.setGender( EntityFactory.createGender( dto._gender._id ) );

        if(dto._country != null)
            entity.setCountry( EntityFactory.createCountry( dto._country._id)  );

        if(dto._registerDate != null )
            entity.setRegisterDate( LocalDate.parse( dto._registerDate ) );

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de UserMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UserDTO mapEntityToDto( User entity )
    {
        final UserDTO dto = new UserDTO();

        //region Instrumentation DEBUG
        //_logger.debug( "Entrando a UserMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._name = entity.getName();
        dto._lastName = entity.getLastName();
        dto._email = entity.getEmail();
        dto._type = entity.getType().getValue();
        dto._status = entity.getStatus().getValue();
        dto._country = MasterMapper.mapEntityToDTO( entity.getCountry() );
        dto._gender = MasterMapper.mapEntityToDTO( entity.getGender() );
        dto._registerDate = entity.getRegisterDate().toString();
        dto._token = entity.getToken();

        //region Instrumentation DEBUG
        //_logger.debug( "Saliendo de UserMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }
}
