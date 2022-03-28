/**
 * 
 */
package br.com.rpires.VendaServiceProfessor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpires.VendaServiceProfessor.domain.Venda;
import br.com.rpires.VendaServiceProfessor.dto.VendaDTO;
import br.com.rpires.VendaServiceProfessor.usecase.BuscaVenda;
import br.com.rpires.VendaServiceProfessor.usecase.CadastroVenda;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author rodrigo.pires
 *
 */
@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

	private BuscaVenda buscaVenda;
	
	private CadastroVenda cadastroVenda;
	
	@Autowired
	public VendaResource(BuscaVenda buscaProduto,
			CadastroVenda cadastroProduto) {
		this.buscaVenda = buscaProduto;
		this.cadastroVenda = cadastroProduto;
	}
	
	@GetMapping
	@Operation(summary = "Busca uma lista paginada de vendas")
	public ResponseEntity<Page<Venda>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscaVenda.buscar(pageable));
	}
	
	@GetMapping(value = "/{codigo}")
	@Operation(summary = "Busca uma venda pelo codigo")
	public ResponseEntity<Venda> buscarPorCodigo(String codigo) {
		return ResponseEntity.ok(buscaVenda.buscarPorCodigo(codigo));
	}
	
	@PostMapping
	@Operation(summary = "Iniciar uma venda")
	public ResponseEntity<Venda> cadastrar(@RequestBody @Valid VendaDTO venda) {
		return ResponseEntity.ok(cadastroVenda.cadastrar(venda));
	}
	
	@PutMapping
	@Operation(summary = "Atualiza uma venda")
	public ResponseEntity<Venda> atualizar(@RequestBody @Valid Venda venda) {
		return ResponseEntity.ok(cadastroVenda.atualizar(venda));
	}	
	
	@PostMapping(value = "/{id}/{codigoProduto}/{quantidade}/adicionarProduto")
	@Operation(summary = "Adiciona produtos a uma venda")
	public ResponseEntity<Venda> adicionarProduto(
			@PathVariable(value = "id", required = true) String id,
			@PathVariable(value = "codigoProduto", required = true) String codigoProduto,
			@PathVariable(value = "quantidade", required = true) Integer quantidade) {
		return ResponseEntity.ok(cadastroVenda.adicionarProduto(id, codigoProduto, quantidade));
	}	
	
	@PostMapping(value = "/{id}/{codigoProduto}/{quantidade}/removerProduto")
	@Operation(summary = "Remove produtos a uma venda")
	public ResponseEntity<Venda> removerProduto(
			@PathVariable(value = "id", required = true) String id,
			@PathVariable(value = "codigoProduto", required = true) String codigoProduto,
			@PathVariable(value = "quantidade", required = true) Integer quantidade) {
		return ResponseEntity.ok(cadastroVenda.removerProduto(id, codigoProduto, quantidade));
	}	
	
	@PutMapping(value = "/{id}/finalizar")
	@Operation(summary = "Finaliza uma venda pelo seu identificador único")
	public ResponseEntity<Venda> finalizar(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(cadastroVenda.finalizar(id));
	}
	
	@PutMapping(value = "/{id}/cancelar")
	@Operation(summary = "Cancela uma venda pelo seu identificador único")
	public ResponseEntity<Venda> cancelar(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(cadastroVenda.cancelar(id));
	}
}
