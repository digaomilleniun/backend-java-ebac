/**
 * 
 */
package br.com.rpires.domain;

import anotacao.TipoChave;
import br.com.rpires.dao.Persistence;

/**
 * @author rodrigo.pires
 *
 */
public class Cliente_2 implements Persistence {
	
	private String nome;
	
	@TipoChave("getCpf")
    private Long cpf;
    
    private Long tel;
    
    private String end;
    
    private Integer numero;
    
    private String cidade;
    
    private String estado;

    public Cliente_2(int ignoredCodigo, String ignoredNome, String ignoredEndereco) {
    }

    public Cliente_2() {
    }

    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public <E> E getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCodigo(String string) {
		// TODO Auto-generated method stub
		return;
	}
}
