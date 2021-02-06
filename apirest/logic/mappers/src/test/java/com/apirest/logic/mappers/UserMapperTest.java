package com.apirest.logic.mappers;

import com.apirest.common.EntityFactory;
import com.apirest.common.entities.User;
import com.apirest.enums.MasterStatus;
import com.apirest.enums.UserType;
import com.apirest.logic.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest
{
    private User _entity;
    private UserDTO _dto;

    @BeforeEach
    public void setUp()
    {
        createEntity();
        createDTO();
    }

    @Test
    public void mapDtoToEntityTest()
    {
        User entity = UserMapper.mapDtoToEntity( _dto );

        assertEquals( entity.getId(), _dto._id );
        assertEquals( entity.getStatus().getValue(), _dto._status );
        assertEquals( entity.getName(), _dto._name );
        assertEquals( entity.getRegisterDate().toString(), _dto._registerDate );
        assertEquals( entity.getToken(), _dto._token );
        assertEquals( entity.getType().getValue(), _dto._type );
        assertEquals( entity.getPassword(), _dto._password );
        assertEquals( entity.getEmail(), _dto._email );
        assertEquals( entity.getSalt(), _dto._salt );
    }

    @Test
    public void mapEntityToDtoTest()
    {
        UserDTO dto = UserMapper.mapEntityToDto( _entity );

        assertEquals( dto._id, _entity.getId() );
        assertEquals( dto._status, _entity.getStatus().getValue() );
        assertEquals( dto._name, _entity.getName() );
        assertEquals( dto._registerDate, _entity.getRegisterDate().toString() );
        assertEquals( dto._token, _entity.getToken() );
        assertEquals( dto._type, _entity.getType().getValue() );
        assertEquals( dto._email, _entity.getEmail() );
    }

    private void createEntity()
    {
        _entity = EntityFactory.createUser();

        _entity.setId( 1 );
        _entity.setStatus( MasterStatus.ACTIVE );
        _entity.setName( "toy" );
        _entity.setRegisterDate( LocalDate.now() );
        _entity.setToken( "token" );
        _entity.setType( UserType.CLIENT );
        _entity.setPassword( "123123" );
        _entity.setEmail( "email@email.com" );
        _entity.setSalt( "salt-123" );
    }

    private void createDTO()
    {
        _dto = new UserDTO();

        _dto._id = _entity.getId();
        _dto._status = _entity.getStatus().getValue();
        _dto._name = _entity.getName();
        _dto._registerDate = _entity.getRegisterDate().toString();
        _dto._token = _entity.getToken();
        _dto._type = _entity.getType().getValue();
        _dto._password = _entity.getPassword();
        _dto._email = _entity.getEmail();
        _dto._salt = _entity.getSalt();
    }

}
