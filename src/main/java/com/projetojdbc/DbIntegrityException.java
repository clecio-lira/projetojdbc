package com.projetojdbc;

public class DbIntegrityException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String msg) {
        super(msg);
    }
}
