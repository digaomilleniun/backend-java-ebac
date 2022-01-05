/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.rpires.dao.CursoDao;
import br.com.rpires.dao.ICursoDao;
import br.com.rpires.dao.IMatriculaDao;
import br.com.rpires.dao.MatriculaDao;
import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;

/**
 * @author rodrigo.pires
 *
 */
public class MatriculaTest {
	
	private IMatriculaDao matriculaDao;
	
	private ICursoDao cursoDao;
	
	public MatriculaTest() {
		matriculaDao = new MatriculaDao();
		cursoDao = new CursoDao();
	}
	
	@After
	public void end() {
		List<Matricula> list = matriculaDao.buscarTodos();
		list.forEach(mat -> matriculaDao.excluir(mat));
		
		List<Curso> listCursos = cursoDao.buscarTodos();
		listCursos.forEach(cur -> cursoDao.excluir(cur));
	}

	@Test
	public void cadastrar() {
		Curso curso = criarCurso("A1");
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat.setCurso(curso);
		mat = matriculaDao.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
	}
	
	@Test
	public void pesquisarPorCurso() {
		Curso curso = criarCurso("A1");
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat.setCurso(curso);
		mat = matriculaDao.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
		Matricula matricBD = matriculaDao.buscarPorCurso(curso);
		assertNotNull(matricBD);
		assertEquals(mat.getId(), matricBD.getId());
	}
	
	@Test
	public void pesquisarPorCodigoCurso() {
		Curso curso = criarCurso("A1");
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat.setCurso(curso);
		mat = matriculaDao.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
		Matricula matricBD = matriculaDao.buscarPorCodigoCurso(curso.getCodigo());
		assertNotNull(matricBD);
		assertEquals(mat.getId(), matricBD.getId());
	}
	
	@Test
	public void pesquisarPorCodigoCursoCriteria() {
		Curso curso = criarCurso("A1");
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat.setCurso(curso);
		mat = matriculaDao.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
		Matricula matricBD = matriculaDao.buscarPorCodigoCursoCriteria(curso.getCodigo());
		assertNotNull(matricBD);
		assertEquals(mat.getId(), matricBD.getId());
	}
	
	@Test
	public void pesquisarPorCursoCriteria() {
		Curso curso = criarCurso("A1");
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat.setCurso(curso);
		mat = matriculaDao.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
		Matricula matricBD = matriculaDao.buscarPorCursoCriteria(curso);
		assertNotNull(matricBD);
		assertEquals(mat.getId(), matricBD.getId());
	}
	
	private Curso criarCurso(String codigo) {
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		curso.setDescricao("CURSO TESTE");
		curso.setNome("Curso de Java Backend");
		return cursoDao.cadastrar(curso);
	}
}
