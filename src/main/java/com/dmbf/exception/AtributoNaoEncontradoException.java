/**
 * 
 */
package com.dmbf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author hugosilva
 *
 */
public class AtributoNaoEncontradoException extends Excecao {

	private static final long serialVersionUID = 4811606380438811694L;
	
	private String dado;
	
	public AtributoNaoEncontradoException(String message, String dado){
		super(message, HttpStatus.BAD_REQUEST);
		this.dado = dado;
	}

	@Override
	public Object getDado() {
		return this.dado;
	}

}

