package cadastro.fabrica;

/**
 * @author rodrigo.pires
 */
public interface IFactory {

    FabricaPersistente criarFabrica(String opcaoMenuGeral);
}
