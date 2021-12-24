package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 *
 * Classe que representa todas as entidades ou objetos da aplicação que seram salvas no banco de dados
 */
public interface Persistente {

    //public Long getCodigo();
	
	public Long getId();
	
	public void setId(Long id);
}
