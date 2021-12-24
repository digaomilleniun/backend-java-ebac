/**
 * 
 */
package br.com.rpires.exceptions;

/**
 * @author rodrigo.pires
 *
 */
public class TipoElementoNaoConhecidoException extends Exception {
	

	private static final long serialVersionUID = -2268140970978666251L;

	public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }

}
