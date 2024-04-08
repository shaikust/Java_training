package com.ust.pharma.exception;

/**
 * Exception Class
 */
public class PharmaBusinessException extends Exception{
    public PharmaBusinessException(){
        super();
    }
    public PharmaBusinessException(String message){
        super(message);

    }
    public PharmaBusinessException(Throwable cause){
        super(cause);
    }


}
