package br.com.imagemfilmes.desafio.controller;

import br.com.imagemfilmes.desafio.entity.Pessoa;
import br.com.imagemfilmes.desafio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/listar")
    public List<Pessoa> listar() throws Exception {
        return pessoaService.getPessoas();
    }

    @GetMapping("/listar/alfabetico")
	public List<Pessoa> listarOrdenadoNome() throws Exception {
		return pessoaService.getPessoasPorNome();
	}

}
