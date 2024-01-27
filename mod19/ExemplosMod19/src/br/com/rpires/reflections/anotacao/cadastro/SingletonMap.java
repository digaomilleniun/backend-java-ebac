package br.com.rpires.reflections.anotacao.cadastro;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rodrigo.pires
 *
 * Classe Singleton que garante que o <code>map</code> será único em toda a vita da aplicação.
 *
 */
public class SingletonMap {

    private static SingletonMap singletonMap;

    /**
     * Contém todos os registros da aplicação.
     * Simula o banco de dados
     */
    @SuppressWarnings("rawtypes")
	protected Map<Class, Map<Long, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    /**
     * Método que garante o retorno de apenas uma instância desse objeto
     *
     * @return SingletonMap
     */
    public static SingletonMap getInstance() {
        if (singletonMap == null) {
            singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    @SuppressWarnings("rawtypes")
	public Map<Class, Map<Long, ?>> getMap() {
        return this.map;
    }
}
