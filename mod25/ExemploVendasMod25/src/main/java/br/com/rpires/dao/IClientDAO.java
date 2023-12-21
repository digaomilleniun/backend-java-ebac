/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.dao.generic.IGenericDAO;

import java.io.Serializable;

/**
 * @author rodrigo.pires
 */

public interface IClientDAO<T extends Persistence, E extends Persistence & Serializable> extends IGenericDAO<T,E> {

}
