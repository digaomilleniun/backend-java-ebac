/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rpires.dao.CursoDao;
import br.com.rpires.dao.ICursoDao;
import br.com.rpires.domain.Curso;

/**
 * @author rodrigo.pires
 *
 */
public class CursoTest {

	private ICursoDao cursoDao;
	
	public CursoTest() {
		cursoDao = new CursoDao();
	}

	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("CURSO TESTE");
		curso.setNome("Curso de Java Backend");
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
	}
}
