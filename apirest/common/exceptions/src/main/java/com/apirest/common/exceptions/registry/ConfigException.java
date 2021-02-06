package com.apirest.common.exceptions.registry;

import com.apirest.common.exceptions.BaseException;

public class ConfigException extends BaseException
{
    public ConfigException( Exception e, String str )
    {
        super( e, str );
    }
}
