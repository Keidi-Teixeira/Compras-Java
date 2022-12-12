package br.com.imagemfilmes.exception;

@SuppressWarnings("serial")
public class BaseDomainException extends RuntimeException {

	  public BaseDomainException(String message) {
	    super(message);
	  }
}