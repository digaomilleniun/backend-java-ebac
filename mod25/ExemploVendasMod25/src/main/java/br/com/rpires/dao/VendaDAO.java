/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.domain.Venda;
import br.com.rpires.domain.Venda.Status;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO_1 {

	@Override
	public Class<Cliente_2> getTipoClasse() {
		return Venda.class;
	}

	@Override
	public void atualiarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());
	}

	@Override
	public void excluir(String valor) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
		venda.setStatus(Status.CONCLUIDA);
		super.alterar(venda);
	}
	
	

}
