package br.com.rpires.pacote1;

/**
 * @author Steve.Vaz
 */
public class Classe2 {

    private String propriedadePrivada;

    public String propriedadePublica;

    String propriedadeDefaul;

    protected String propriedadeProtected;

    public String getPropriedadePrivada() {
		return propriedadePrivada;
	}

	public void setPropriedadePrivada(String propriedadePrivada) {
		this.propriedadePrivada = propriedadePrivada;
	}
    
    public static void main(String args[]) {
        @SuppressWarnings("unused")
		Classe1 classe1 = new Classe1();
        //classe1.propriedadeDefaul
    }

}
