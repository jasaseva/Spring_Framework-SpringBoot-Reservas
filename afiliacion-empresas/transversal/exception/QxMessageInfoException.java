package com.comfenalcoantioquia.transversal.exception;

/**
 * Se controlan las excepciones con mensajes configurables Creado el 7/02/2013 a las 17:03:31 <br>
 * 
 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
 */
public class QxMessageInfoException extends Exception {

	private static final long serialVersionUID = 1790467606973089884L;

	private int codException;
	private String codigoException;

	public QxMessageInfoException(int codException) {
		this.codException = codException;
	}

	public QxMessageInfoException(int codException, Exception e) {
		super(e.getMessage(), e);
		this.codException = codException;
	}

	public QxMessageInfoException(int codException, String codigoException) {
		this.codException = codException;
		this.codigoException = codigoException;
	}

	public QxMessageInfoException(int codException, String codigoException, Exception e) {
		super(e.getMessage(), e);
		this.codException = codException;
		this.codigoException = codigoException;
	}

	public QxMessageInfoException(String codigoException) {
		this.codigoException = codigoException;
	}

	public QxMessageInfoException(String codigoException, Exception e) {
		super(e.getMessage(), e);
		this.codigoException = codigoException;
	}

	public int getCodException() {
		return codException;
	}

	public String getCodigoException() {
		return codigoException;
	}

}
