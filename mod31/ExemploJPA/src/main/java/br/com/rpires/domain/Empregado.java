/**
 * 
 */
package br.com.rpires.domain;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

/**
 * @author rodrigo.pires
 *
 */
@Entity
@Table(name = "TB_EMPREGADO")
public class Empregado {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ElementCollection
	@CollectionTable(name="TB_EMPREGADOS_TELEFONES")
	@MapKeyColumn(name="tipo_telefone")
	@Column(name="numero_telefone")
	private Map<String, String> numeroTelefones;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "TB_EMPREGADO_PROJETO", 
        joinColumns = { @JoinColumn(name = "empregado_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "projeto_id") }
    )
    Set<Projeto> projetos = new HashSet<>();
}
