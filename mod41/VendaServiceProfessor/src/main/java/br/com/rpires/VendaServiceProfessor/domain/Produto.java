/**
 * 
 */
package br.com.rpires.VendaServiceProfessor.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rodrigo.pires
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
	
	private String id;

	@NotNull
	@Size(min = 2, max = 10)
	private String codigo;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nome;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String descricao;
	
	@NotNull
	private BigDecimal valor;
	
}
