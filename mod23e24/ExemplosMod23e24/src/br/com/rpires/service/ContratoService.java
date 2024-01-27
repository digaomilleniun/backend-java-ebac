package br.com.rpires.service;

import br.com.rpires.dao.Junit.IContratoDao;

/**
 * @author rodrigo.pires
 */
public abstract class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }
}
