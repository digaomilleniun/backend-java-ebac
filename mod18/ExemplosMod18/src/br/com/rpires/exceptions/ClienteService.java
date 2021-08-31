package br.com.rpires.exceptions;

/**
 * @author rodrigo.pires
 */
public class ClienteService {

    public static void consutlarCliente(String codigo) throws ClienteNaoEncontrato2Exception {
        try {
            ClienteDAO.consutlarCliente(codigo);
        } catch (ClienteNaoEncontradoException e) {
            throw new ClienteNaoEncontrato2Exception(e.getMessage(), e);
        }
    }
}
