/**
 * 
 */
package br.com.rpires.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author rodrigo.pires
 *
 */
@Entity
@Table(name = "TB_PROJETO")
public class Projeto {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToMany(mappedBy = "projetos")
    private Set<Empregado> empregados = new HashSet<>();
}
