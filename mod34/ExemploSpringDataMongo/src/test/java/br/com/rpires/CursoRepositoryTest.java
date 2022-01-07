/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rpires.config.MongoConfig;
import br.com.rpires.domain.Curso;
import br.com.rpires.repository.ICursoRepository;

/**
 * @author rodrigo.pires
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class CursoRepositoryTest {

	@Autowired
	private ICursoRepository cursoRepository;
	
	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("CURSO TESTE - Spring data e mongoDB");
		curso.setNome("Curso de Java Backend");
		curso = cursoRepository.insert(curso);
		
		assertNotNull(curso);
	}
}
