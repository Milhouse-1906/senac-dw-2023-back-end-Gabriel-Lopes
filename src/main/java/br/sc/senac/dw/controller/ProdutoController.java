package br.sc.senac.dw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entidade.Produto;
import br.sc.senac.dw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos") // shorthand for @Controller and @ResponseBody rolled together
public class ProdutoController {

	@Autowired
	private ProdutoService produtoServiceAntigoBO;
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> listarTodos() {
		return produtoServiceAntigoBO.listarTodos();
	}

	@GetMapping("/{id}")
	public Optional<Produto> pesquisarPorId(@PathVariable Integer id) {
		return produtoService.consultarPorId(id.longValue());
	}
	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) 
		throws CampoInvalidoException {
		return  produtoService.inserir(novoProduto);
		
	}
}