/**
 * 
 */
package br.com.rpires.ProdutoServiceProfessor.usecase;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rpires.ProdutoServiceProfessor.domain.Produto;
import br.com.rpires.ProdutoServiceProfessor.domain.Produto.Status;
import br.com.rpires.ProdutoServiceProfessor.exception.EntityNotFoundException;
import br.com.rpires.ProdutoServiceProfessor.repository.IProdutoRepository;

/**
 * @author rodrigo.pires
 *
 */
@Service
public class CadastroProduto {
	
	private IProdutoRepository produtoRepository;
	
	@Autowired
	public CadastroProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto cadastrar(@Valid Produto produto) {
		produto.setStatus(Status.ATIVO);
		return this.produtoRepository.insert(produto);
	}

	public Produto atualizar(@Valid Produto produto) {
		return this.produtoRepository.save(produto);
	}

	public void remover(String id) {
		Produto prod = produtoRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException(Produto.class, "id", id));
		prod.setStatus(Status.INATIVO);
		this.produtoRepository.save(prod);
		//this.produtoRepository.deleteById(id);
	}

}
