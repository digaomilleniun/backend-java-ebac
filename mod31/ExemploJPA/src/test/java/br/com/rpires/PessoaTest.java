/**
 * 
 */
package br.com.rpires;

import org.junit.Test;

import br.com.rpires.domain.Pessoa;

/**
 * @author rodrigo.pires
 *
 */
public class PessoaTest {

	
	
	@Test
	public void cadastrar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Rodrigo");
		pessoa.addApelido("Rodrigão");
		//pessoaDao.cadastrar(pessoa);
	}
}
