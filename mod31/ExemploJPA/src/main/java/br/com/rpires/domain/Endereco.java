/**
 * 
 */
package br.com.rpires.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author rodrigo.pires
 *
 */
@Embeddable
public class Endereco {

	@Column(name="rua")
	private String rua;
	
	@Column(name="numero")
    private int numero;
    
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
    
    
}
