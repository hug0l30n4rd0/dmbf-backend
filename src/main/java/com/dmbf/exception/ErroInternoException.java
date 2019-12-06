/**
 * 
 */
package com.dmbf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author hugosilva
 *
 */
public class ErroInternoException extends Excecao {

	private static final long serialVersionUID = -7989229349300739644L;

	public ErroInternoException(){
		super("erro interno", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Object getDado() {
		return null;
	}
	
}
