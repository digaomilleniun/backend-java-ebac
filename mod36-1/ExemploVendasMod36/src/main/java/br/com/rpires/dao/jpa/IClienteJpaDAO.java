/**
 * 
 */
package br.com.rpires.dao.jpa;

import br.com.rpires.dao.generic.jpa.IGenericJapDAO;
import br.com.rpires.domain.jpa.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
