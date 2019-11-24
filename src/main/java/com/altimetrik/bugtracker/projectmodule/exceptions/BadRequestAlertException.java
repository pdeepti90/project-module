package com.altimetrik.bugtracker.projectmodule.exceptions;

public class BadRequestAlertException  extends Exception{
    private String message;
    public BadRequestAlertException(String message){
        this.message = message;
    }
}
