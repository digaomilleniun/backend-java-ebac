package cadastro.fabrica;

import cadastro.domain.Persistente;

/**
 * @author rodrigo.pires
 */
public interface FabricaPersistente {

    Persistente criarObjeto(String dados[]);

}
