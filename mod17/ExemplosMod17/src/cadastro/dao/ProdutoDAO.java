package cadastro.dao;

import cadastro.SingletonMap;
import cadastro.dao.generic.GenericDAO;
import cadastro.domain.Cliente;
import cadastro.domain.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

	public ProdutoDAO() {
		@SuppressWarnings("unchecked")
		Map<Long, Produto> mapaInterno = (Map<Long, Produto>) SingletonMap.getInstance().getMap().get(getTipoClasse());
		if (mapaInterno == null) {
			mapaInterno = new HashMap<>();
			SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
		}
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public Boolean cadastrar(Produto persistente) {
		@SuppressWarnings("unchecked")
		Map<Long, Produto> mapaInterno = (Map<Long, Produto>) SingletonMap.getInstance().getMap().get(getTipoClasse());
		if (!mapaInterno.containsKey(persistente.getCodigo())) {
			mapaInterno.put(persistente.getCodigo(), persistente);
			return true; // Cadastro bem-sucedido
		}
		return false; // Produto já cadastrado
	}

	@Override
	public void atualizarDados(Produto entity, Produto entityCadastrado) {
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setCodigo(entity.getCodigo());
	}

	@Override
	public void alterar(Produto produto) {
		@SuppressWarnings("unchecked")
		Map<Long, Produto> mapaInterno = (Map<Long, Produto>) SingletonMap.getInstance().getMap().get(getTipoClasse());
		Produto produtoCadastrado = mapaInterno.get(produto.getCodigo());
		if (produtoCadastrado != null) {
			atualizarDados(produto, produtoCadastrado);
		}
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualiarDados(Produto entity, Produto entityCadastrado) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean cadastrar(Cliente persistente) {
		// TODO Auto-generated method stub
		return null;
	}
}
