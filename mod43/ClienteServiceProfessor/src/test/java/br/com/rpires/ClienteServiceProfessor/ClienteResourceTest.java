/**
 * 
 */
package br.com.rpires.ClienteServiceProfessor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import br.com.rpires.ClienteServiceProfessor.config.OpenAPIConfig;
import br.com.rpires.ClienteServiceProfessor.controller.ClienteResource;
import br.com.rpires.ClienteServiceProfessor.domain.Cliente;
import br.com.rpires.ClienteServiceProfessor.exception.EntityNotFoundException;
import br.com.rpires.ClienteServiceProfessor.usecase.BuscaCliente;
import br.com.rpires.ClienteServiceProfessor.usecase.CadastroCliente;

/**
 * @author rodrigo.pires
 *
 */
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class ClienteResourceTest {
	
//	private MockMvc mvc;
	
//	@InjectMocks
	private ClienteResource clienteResource;
	
//	@MockBean
	private BuscaCliente buscaCliente;
	
//	@MockBean
	private CadastroCliente cadastroCliente;
	
//	@MockBean
//	private OpenAPIConfig openAPIConfig;
	
//	@BeforeEach
    public void setup() {
		MockitoAnnotations.openMocks(this);
//		 mvc = MockMvcBuilders.standaloneSetup(clienteResource)
//	                .setControllerAdvice(new RestExceptionHandler())
//	                .build();
	}
	
	
//	@Test
	public void pesquisarPorIdTest() {
        Cliente cliente1 = Cliente.builder().id("1").nome("Rodrigo 1").build();
 
        when(buscaCliente.buscarPorId("1")).thenReturn(cliente1);
 
        ResponseEntity<Cliente> result = clienteResource.buscarPorId("1");
 
        Cliente clienteResult = result.getBody();
        assertThat(clienteResult).isEqualTo(cliente1);
        assertThat(clienteResult.getId()).isEqualTo(cliente1.getId());
        assertThat(clienteResult.getNome()).isEqualTo(cliente1.getNome());
	}
	
//	@Test
	public void isClienteCadastradoTest() {
 
        when(buscaCliente.isCadastrado("1")).thenReturn(true);
 
        ResponseEntity<Boolean> result = clienteResource.isCadastrado("1");
 
        Boolean isCadastrado = result.getBody();
        assertThat(isCadastrado).isEqualTo(true);
	}
	
//	@Test
	public void cadastrarTest() {
        Cliente cliente1 = Cliente.builder().id("1").nome("Rodrigo 1")
        		.cpf(102030L).email("Teste@teste").end("end")
        		.tel(102030L).cidade("SP").estado("SP").build();
 
        when(cadastroCliente.cadastrar(cliente1)).thenReturn(cliente1);
 
        ResponseEntity<Cliente> result = clienteResource.cadastrar(cliente1);
 
        Cliente clienteResult = result.getBody();
        assertThat(clienteResult).isEqualTo(cliente1);
        assertThat(clienteResult.getId()).isEqualTo(cliente1.getId());
        assertThat(clienteResult.getNome()).isEqualTo(cliente1.getNome());
	}
	
//	@Test
	public void atualizarTest() {
        Cliente cliente1 = Cliente.builder().id("1").nome("Rodrigo 1")
        		.cpf(102030L).email("Teste@teste").end("end")
        		.tel(102030L).cidade("SP").estado("SP").build();
 
        when(cadastroCliente.cadastrar(cliente1)).thenReturn(cliente1);
 
        ResponseEntity<Cliente> result = clienteResource.cadastrar(cliente1);
 
        Cliente clienteResult = result.getBody();
        assertThat(clienteResult).isEqualTo(cliente1);
        assertThat(clienteResult.getId()).isEqualTo(cliente1.getId());
        assertThat(clienteResult.getNome()).isEqualTo(cliente1.getNome());
        
        
        cliente1.setNome("Rodrigo Pires");
 
        when(cadastroCliente.atualizar(cliente1)).thenReturn(cliente1);
 
        ResponseEntity<Cliente> result1 = clienteResource.atualizar(cliente1);
 
        Cliente clienteResult1 = result1.getBody();
        assertThat(clienteResult1).isEqualTo(cliente1);
        assertThat(clienteResult1.getId()).isEqualTo(cliente1.getId());
        assertThat(clienteResult1.getNome()).isEqualTo(cliente1.getNome());
	}
	
//	@Test
	public void excluirTest() {
        Cliente cliente1 = Cliente.builder().id("1").nome("Rodrigo 1")
        		.cpf(102030L).email("Teste@teste").end("end")
        		.tel(102030L).cidade("SP").estado("SP").build();
 
        when(cadastroCliente.cadastrar(cliente1)).thenReturn(cliente1);
 
        ResponseEntity<Cliente> result = clienteResource.cadastrar(cliente1);
 
        Cliente clienteResult = result.getBody();
        assertThat(clienteResult).isEqualTo(cliente1);
        assertThat(clienteResult.getId()).isEqualTo(cliente1.getId());
        assertThat(clienteResult.getNome()).isEqualTo(cliente1.getNome());
        
        doNothing().when(cadastroCliente).remover(cliente1.getId());
 
        ResponseEntity<String> result1 = clienteResource.remover(cliente1.getId());
 
        String clienteResult1 = result1.getBody();
        assertThat(clienteResult1).isEqualTo("Removido com sucesso");
	}
	
//	@Test
	public void buscarNaoCadastradoTest() {
		EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
	        when(buscaCliente.buscarPorId("2")).thenThrow(new EntityNotFoundException(Cliente.class, "id", "2"));
	        clienteResource.buscarPorId("2");
	    });

	    String expectedMessage = "Cliente was not found for parameters {id=2}";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

}
