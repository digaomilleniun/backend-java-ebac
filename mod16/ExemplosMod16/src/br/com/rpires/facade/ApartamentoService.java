package br.com.rpires.facade;

/**
 * @author rodrigo.pires
 */
public class ApartamentoService implements IApartamentoService {

    @Override
    public Boolean cadastarApartamento(Apartamento apartamento) {
        Boolean isCadastrado = isPartamentoCadastrado(apartamento);
        Boolean isCamposValidos = isCamposValidos(apartamento);
        if (isCadastrado && !isCamposValidos) {
            return false;
        }

        return cadastrarNoBanco(apartamento);

    }

    private Boolean cadastrarNoBanco(Apartamento apartamento) {
        //lógica de cadastro
        return true;
    }

    private Boolean isPartamentoCadastrado(Apartamento apartamento) {
        //Ir no banco e verificar se está cadastrado
        return false;
    }

    private Boolean isCamposValidos(Apartamento apartamento) {
        return true;
    }
}
