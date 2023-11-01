package br.com.rpires;

import org.junit.Test;

import br.com.rpires.dao.ClienteDao;
import br.com.rpires.dao.ClienteDaoMock;
import br.com.rpires.dao.IClienteDao;
import br.com.rpires.service.ClienteService;

/**
 * @author rodrigo.pires
 */
public class ClienteServiceTest {

    @SuppressWarnings("deprecation")
	@Test
    public void salvarTest() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        junit.framework.Assert.assertEquals("Sucesso", retorno);
    }

    @SuppressWarnings("deprecation")
	@Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        junit.framework.Assert.assertEquals("Sucesso", retorno);
    }
}
