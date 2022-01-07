/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.junit.Test;

import br.com.rpires.dao.CursoDao;
import br.com.rpires.dao.ICursoDao;
import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;

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
		Matricula matric = new Matricula();
//		matric.setId(new ObjectId());
		matric.setCodigo("A1");
		matric.setDataMatricula(Instant.now());
		matric.setStatus("ATIVA");
		matric.setValor(2000.00d);
		
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("CURSO TESTE");
		curso.setNome("Curso de Java Backend");
		curso.add(matric);
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
	}
}
