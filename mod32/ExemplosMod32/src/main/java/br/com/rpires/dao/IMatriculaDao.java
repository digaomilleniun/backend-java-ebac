/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;

/**
 * @author rodrigo.pires
 *
 */
public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);
	
	Matricula buscarPorCodigoCurso(String codigoCurso);
	
	Matricula buscarPorCurso(Curso curso);
	
	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
	
	Matricula buscarPorCursoCriteria(Curso curso);
	
	List<Matricula> buscarTodos();
	
	void excluir(Matricula matricula);
}
