package cadastro.fabrica;

import cadastro.domain.Persistente;
import cadastro.domain.Produto;

/**
 * @author rodrigo.pires
 */
public class ProdutoFabrica implements FabricaPersistente {

    @Override
    public Persistente criarObjeto(String[] dados) {
        Produto produto = new Produto();
        produto.setCodigo(Long.parseLong(dados[0].trim()));
        produto.setNome(dados[1]);
        return produto;
    }
}
