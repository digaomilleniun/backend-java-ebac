/**
 * 
 */
package br.com.rpires.ClienteServiceProfessor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpires.ClienteServiceProfessor.domain.Cliente;
import br.com.rpires.ClienteServiceProfessor.usecase.BuscaCliente;
import br.com.rpires.ClienteServiceProfessor.usecase.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author rodrigo.pires
 *
 */
@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	private BuscaCliente buscaCliente;
	
	private CadastroCliente cadastroCliente;
	
	@Autowired
	public ClienteResource(BuscaCliente buscarCliente, 
			CadastroCliente cadastroCliente) {
		this.buscaCliente = buscarCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	@GetMapping
	@Operation(summary = "Busca uma lista paginada de clientes")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Retorna a lista de clientes"),
		    @ApiResponse(responseCode = "400", description = "Requisição malformada ou erro de sintaxe", 
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "BAD_REQUEST"))),
		    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção",
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "INTERNAL_SERVER_ERROR"))),
		})
	public ResponseEntity<Page<Cliente>> buscar(@Parameter(description="Objeto de paginação") Pageable pageable) {
		return ResponseEntity.ok(buscaCliente.buscar(pageable));
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca um cliente pelo id")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscaCliente.buscarPorId(id));
	}
	
	@GetMapping(value = "isCadastrado/{id}")
	@Operation(summary = "Busca um cliente pelo id")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscaCliente.isCadastrado(id));
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	@Operation(summary = "Busca um cliente pelo cpf")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
		return ResponseEntity.ok(buscaCliente.buscarPorCpf(cpf));
	}
	
	@PostMapping
	@Operation(summary = "Cadastrar um cliente")
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
	}	
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um cliente pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		cadastroCliente.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}
}
