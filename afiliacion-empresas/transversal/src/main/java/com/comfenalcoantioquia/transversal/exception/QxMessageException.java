package com.comfenalcoantioquia.transversal.exception;

/**
 * Se controlan las excepciones con mensajes configurables Creado el 7/02/2013 a las 17:03:31 <br>
 * 
 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
 */
public class QxMessageException extends QxException {

	private static final long serialVersionUID = 1790467606973089884L;

	private int codException;
	private String codigoException;

	public QxMessageException(int codException) {
		this.codException = codException;
	}

	public QxMessageException(int codException, Exception e) {
		super(e.getMessage(), e);
		this.codException = codException;
	}

	public QxMessageException(int codException, String codigoException) {
		this.codException = codException;
		this.codigoException = codigoException;
	}

	public QxMessageException(int codException, String codigoException, Exception e) {
		super(e.getMessage(), e);
		this.codException = codException;
		this.codigoException = codigoException;
	}

	public QxMessageException(String codigoException) {
		this.codigoException = codigoException;
	}

	public QxMessageException(String codigoException, Exception e) {
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
