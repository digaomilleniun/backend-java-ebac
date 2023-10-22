package br.com.rpires.exceptions;

/**
 * @author Steve.Vaz
 */
public class ClienteNaoEncontrato2Exception extends Exception{

    private static final long serialVersionUID = 1L;

	public ClienteNaoEncontrato2Exception(String msg, Throwable e) {
        super(msg,e);
    }
}
