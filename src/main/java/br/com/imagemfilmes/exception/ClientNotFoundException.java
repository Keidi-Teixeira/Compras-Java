package br.com.imagemfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientNotFoundException extends BaseDomainException {
	
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String mensagem) {
        super(mensagem);
    }
    
    public ClientNotFoundException(Long ClienteId ) {
        this(String.format("Não existe um cliente com código %d", ClienteId));
    } 

}
