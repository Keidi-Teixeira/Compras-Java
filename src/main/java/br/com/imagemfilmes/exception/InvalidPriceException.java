package br.com.imagemfilmes.exception;

@SuppressWarnings("serial")
public class InvalidPriceException extends BaseDomainException{

	public InvalidPriceException(String message) {
		super("Preço inválido!");
		// TODO Auto-generated constructor stub
	}
	

}
