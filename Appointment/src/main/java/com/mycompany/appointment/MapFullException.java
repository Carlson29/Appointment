package com.mycompany.appointment;



/**
 *
 * @author michelle
 */
public class MapFullException extends RuntimeException{
    public MapFullException(String message){
        super(message);
    }
    
    public MapFullException(){
        super();
    }
}