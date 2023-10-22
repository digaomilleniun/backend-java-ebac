package br.com.rpires.exceptions;

/**
 * @author Steve.Vaz
 */
public class ClienteNaoEncontradoException extends Exception {

    private static final long serialVersionUID = 7532237876687060105L;

	public ClienteNaoEncontradoException(String msg) {
        super(msg);
    }
}
