/**
 * 
 */
package com.dmbf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author hugosilva
 *
 */
public class OrdenadorInvalidoException extends Excecao {

	private static final long serialVersionUID = 7371926716265883744L;
	
	private String dado;
	
	public OrdenadorInvalidoException(String message, String dado){
		super(message, HttpStatus.BAD_REQUEST);
		this.dado = dado;
	}

	@Override
	public Object getDado() {
		return this.dado;
	}

}
