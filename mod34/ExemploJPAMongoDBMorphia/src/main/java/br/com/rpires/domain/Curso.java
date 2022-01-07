/**
 * 
 */
package br.com.rpires.domain;

import java.util.ArrayList;
import java.util.List;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;


/**
 * @author rodrigo.pires
 *
 */
@Entity
public class Curso {

	@Id
	private String id;
	
	private String codigo;
	
	private String nome;
	
	private String descricao;
	
	@Embedded
//	@Reference
	private List<Matricula> matriculas;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public void add(Matricula matric) {
		if (matriculas == null) {
			this.matriculas = new ArrayList<>();
		}
		this.matriculas.add(matric);
	}
	
	
	
}
