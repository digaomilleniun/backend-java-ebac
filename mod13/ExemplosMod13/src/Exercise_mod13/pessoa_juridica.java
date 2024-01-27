package Exercise_mod13;

public class pessoa_juridica extends pessoa {
	// Propriedades da pessoa jurídica.
    private int TributacaoDiferenciada;
    private String ExistenciaPermanente;
    private double IRPJ;

    public pessoa_juridica(String name, int aliquota, double rendaBruta, double deduçoes, double parcelaAdeduzir, double lucroTributavel) {
        super(name, aliquota, rendaBruta, deduçoes, parcelaAdeduzir, lucroTributavel);
    }

    public String getExistenciaPermanente() {
        return ExistenciaPermanente;
    }

    public void setExistenciaPermanente(String existenciaPermanente) {
        ExistenciaPermanente = existenciaPermanente;
    }

    public int getTributacaoDiferenciada() {
        return TributacaoDiferenciada;
    }

    public void setTributacaoDiferenciada(int tributaçãoDiferenciada) {
        TributacaoDiferenciada = tributaçãoDiferenciada;
    }

    public double getIRPJ() {
        return IRPJ;
    }

    public void setIRPJ(double IRPJ) {
        this.IRPJ = IRPJ;
    }
}