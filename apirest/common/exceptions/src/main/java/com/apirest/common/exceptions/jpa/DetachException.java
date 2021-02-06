package com.apirest.common.exceptions.jpa;

import com.apirest.common.exceptions.BaseException;

public class DetachException extends BaseException
{
    public DetachException( Exception e, String str )
    {
        super( e, str );
    }
}
