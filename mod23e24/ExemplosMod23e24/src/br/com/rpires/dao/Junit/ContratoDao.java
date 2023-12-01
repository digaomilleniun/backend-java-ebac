package br.com.rpires.dao.Junit;

/**
 * @author rodrigo.pires
 */
public class ContratoDao implements IContratoDao {

    public ContratoDao(Object buscar, Object excluir, Object atualizar) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

	@Override
	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
}
