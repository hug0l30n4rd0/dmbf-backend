/**
 * 
 */
package com.dmbf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author hugosilva
 *
 */
public abstract class Excecao extends Exception {

	private static final long serialVersionUID = 4238269051556101854L;

	/**
	 * {@link HttpStatus} associado ao erro.
	 */
	protected HttpStatus status;
	
	public Excecao(String message, HttpStatus status){
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	/**
	 * Método que retorna o dado que causou o lançamento da exceção
	 * @return 
	 */
	public abstract Object getDado();
}
