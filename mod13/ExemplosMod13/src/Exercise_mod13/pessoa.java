package Exercise_mod13;

public abstract class pessoa {
    private String name;
    private int aliquota;
    private double rendaBruta;
    private double deducoes;
    private double parcelaAdeduzir;
    private double lucroTributavel;

    public pessoa(String name, int aliquota, double rendaBruta, double deducoes, double parcelaAdeduzir, double lucroTributavel) {
        super();
        this.name = name;
        this.aliquota = aliquota;
        this.rendaBruta = rendaBruta;
        this.deducoes = deducoes;
        this.parcelaAdeduzir = parcelaAdeduzir;
        this.lucroTributavel = lucroTributavel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAliquota() {
        return aliquota;
    }

    public void setAliquota(int aliquota) {
        this.aliquota = aliquota;
    }

    public double getRendaBruta() {
        return rendaBruta;
    }

    public void setRendaBruta(double rendaBruta) {
        this.rendaBruta = rendaBruta;
    }

    public double getDeducoes() {
        return deducoes;
    }

    public void setDeducoes(double deduçoes) {
        this.deducoes = deduçoes;
    }

    public double getParcelaAdeduzir() {
        return parcelaAdeduzir;
    }

    public void setParcelaAdeduzir(double parcelaAdeduzir) {
        this.parcelaAdeduzir = parcelaAdeduzir;
    }

    public double getLucroTributavel() {
        return lucroTributavel;
    }

    public void setLucroTributavel(double lucroTributavel) {
        this.lucroTributavel = lucroTributavel;
    }
}