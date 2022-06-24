package com.prime.exception;

import java.io.Serializable;

public class NegocioException extends Exception implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public NegocioException() {
    }

    public NegocioException(String message) {
        super(message);
    }
    
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegocioException(Throwable cause) {
        super(cause);
    }

    public NegocioException(String message, Throwable cause, 
                           boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
