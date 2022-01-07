package br.com.rpires.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author rodrigo.pires
 *
 */
@Document(collection = "Matricula_spd")
public class Matricula {

	@Id
	private String id;
	
	private String codigo;
	
	private Instant dataMatricula;
	
	private Double valor;
	
	private String status;
	
	private Curso curso;

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

	public Instant getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Instant dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
