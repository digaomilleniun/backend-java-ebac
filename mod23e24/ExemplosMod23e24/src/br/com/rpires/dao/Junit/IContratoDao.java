package br.com.rpires.dao.Junit;

import br.com.rpires.service.IContratoService;

/**
 * @author rodrigo.pires
 */
public interface IContratoDao extends IContratoService {
    String salvar();

    //TODO
    //Fazer métodos de buscar, excluir e atualizar
    
    void buscar();
    void excluir();
    void atualizar();
    
}
