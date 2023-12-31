package br.sc.senac.dw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.sc.senac.dw.model.entidade.Produto;
import br.sc.senac.dw.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    private ProdutoRepository produtoRepositoryAntigoDAO;

	@Transactional
	public List<Produto> listarTodos() {
		return produtoRepositoryAntigoDAO.findAll();
	}
	public Optional<Produto> consultarPorId(Long id){
		return produtoRepositoryAntigoDAO.findById(id);
	}
	public Produto inserir(Produto novoProduto) {
		return produtoRepositoryAntigoDAO.save(novoProduto);
	}
	
}
