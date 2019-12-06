/**
 * 
 */
package com.dmbf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author hugosilva
 *
 */
public class ParametroInvalidoException extends Excecao {

	private static final long serialVersionUID = 914179343980944545L;

	private Object dado;
	
	public ParametroInvalidoException(String message, Object dado){
		super(message, HttpStatus.BAD_REQUEST);
		this.dado = dado;
	}

	@Override
	public Object getDado() {
		return this.dado;
	}
	
}
