/**
 * 
 */
package br.com.rpires.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * @author rodrigo.pires
 *
 */
@Entity
@Table(name = "TB_CURSO")
public class Curso {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "curso")
    @OrderColumn(name="ordem_matricula")
    private List<Matricula> matriculas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	

}
