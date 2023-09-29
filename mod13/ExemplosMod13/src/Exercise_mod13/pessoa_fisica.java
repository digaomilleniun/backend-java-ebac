package Exercise_mod13;

public class pessoa_fisica extends pessoa {
	// Propriedades da pessoa física.
    private String existenciaBiologica;
    private String CaracteristicasHumanaseEmocoes;
    private double IRPF;

    public pessoa_fisica(String name, int aliquota, double rendaBruta, double deduçoes, double parcelaAdeduzir, double lucroTributavel) {
        super(name, aliquota, rendaBruta, deduçoes, parcelaAdeduzir, 0);
    }

    public String getExistenciaBiologica() {
        return existenciaBiologica;
    }

    public void setExistenciaBiologica(String existenciaBiologica) {
        this.existenciaBiologica = existenciaBiologica;
    }

    public String getCaracteristicasHumanaseEmocoes() {
        return CaracteristicasHumanaseEmocoes;
    }

    public void setCaracterísticasHumanaseEmocoes(String caracteristicasHumanaseEmocoes) {
        CaracteristicasHumanaseEmocoes = caracteristicasHumanaseEmocoes;
    }

    public double getIRPF() {
        return IRPF;
    }

    public void setIRPF(double IRPF) {
        this.IRPF = IRPF;
    }
}