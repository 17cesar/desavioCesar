package com.bentoTech.desavioCesar.util.exceptions;

public class Exception extends RuntimeException{

	public Exception() {
		super();
	}

	public Exception(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": "+getMessage();
	}
	
	
}
