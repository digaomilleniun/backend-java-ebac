/**
 * 
 */
package br.com.rpires.dao.generic.jpa;

import java.io.Serializable;

import br.com.rpires.domain.jpa.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public abstract class GenericJpaDB2DAO <T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB2DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre2");
	}

}
