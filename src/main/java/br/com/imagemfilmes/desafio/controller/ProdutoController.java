package br.com.imagemfilmes.desafio.controller;

import br.com.imagemfilmes.desafio.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.imagemfilmes.desafio.service.ProdutoService;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/listar")
	public List<Produto> listar() throws Exception {
		return produtoService.getProdutos();

	}

	@GetMapping("/listar/preco")
	public List<Produto> listarOrdenadoPorPreco() throws Exception {
		return produtoService.getProdutosPorPreco();
	}

}
