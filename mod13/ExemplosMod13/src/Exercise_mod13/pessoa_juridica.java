package Exercise_mod13;

public class pessoa_juridica extends pessoa {
	// Propriedades da pessoa jurídica.
    private int TributaçãoDiferenciada;
    private String ExistênciaPermanente;
    private double IRPJ;

    public pessoa_juridica(String name, int aliquota, double rendaBruta, double deduçoes, double parcelaAdeduzir, double lucroTributavel) {
        super(name, aliquota, rendaBruta, deduçoes, parcelaAdeduzir, lucroTributavel);
    }

    public String getExistênciaPermanente() {
        return ExistênciaPermanente;
    }

    public void setExistênciaPermanente(String existênciaPermanente) {
        ExistênciaPermanente = existênciaPermanente;
    }

    public int getTributaçãoDiferenciada() {
        return TributaçãoDiferenciada;
    }

    public void setTributaçãoDiferenciada(int tributaçãoDiferenciada) {
        TributaçãoDiferenciada = tributaçãoDiferenciada;
    }

    public double getIRPJ() {
        return IRPJ;
    }

    public void setIRPJ(double IRPJ) {
        this.IRPJ = IRPJ;
    }
}