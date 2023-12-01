package br.com.rpires;

import br.com.rpires.dao.Junit.ContratoDao;
import br.com.rpires.dao.Junit.IContratoDao;
import br.com.rpires.dao.mocks.ContratoDaoMock;
import br.com.rpires.service.ContratoService;
import br.com.rpires.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author rodrigo.pires
 */
public class ContratoServiceTest {

    private Object atualizar;

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock() {
            @Override
            public void buscar() {
                
            }

            @Override
            public void excluir() {

            }

            @Override
            public void atualizar() {

            }
        };
        IContratoService service = new ContratoService(dao) {
            @Override
            public void buscar() {
                
            }

            @Override
            public void excluir() {

            }

            @Override
            public void atualizar() {

            }
        };
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao(atualizar, atualizar, atualizar);
        IContratoService service = new ContratoService(dao) {
            @Override
            public void buscar() {
                
            }

            @Override
            public void excluir() {

            }

            @Override
            public void atualizar() {

            }
        };
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    //TODO
    //Fazer métodos de buscar, excluir e atualizar
    
    @Test(expected = UnsupportedOperationException.class)
    public void methods() {
    	IContratoDao dao;
        Object excluir = new Object();
        Object buscar = null;
		dao = new ContratoDao(buscar, excluir, atualizar);
        IContratoService service = new ContratoService(dao) {
            @Override
            public void buscar() {
                
            }

            @Override
            public void excluir() {

            }

            @Override
            public void atualizar() {

            }
        };
         String retorno = service.salvar();
         Assert.assertEquals("Sucesso", retorno);
    }
}
