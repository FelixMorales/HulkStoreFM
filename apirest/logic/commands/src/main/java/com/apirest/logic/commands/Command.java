package com.apirest.logic.commands;

import com.apirest.persistence.DBHandler;

public abstract  class Command<T>
{
    private DBHandler _handler;

    public Command()
    {
    }

    public Command( DBHandler handler )
    {
        _handler = handler;
    }

    public abstract void execute();

    public abstract T getReturnParam();

    /**
     * Name: closeSession
     * Description: Commit changes and close database session
     */
    public void closeSession()
    {
        _handler.finishTransaction();
        _handler.closeSession();
    }

    /**
     * Name: createSession
     * Description: Create a database session
     *
     * @param transaction start a transaction (only for INSERT, UPDATE and DELETE)
     */
    protected void createSession( boolean transaction )
    {
        _handler = new DBHandler();

        if( transaction )
            _handler.beginTransaction();
    }

    /**
     * Name: getType
     * Description: Getter of database handler
     *
     * @return JPA handler
     */
    protected DBHandler getHandler()
    {
        return _handler;
    }
}
