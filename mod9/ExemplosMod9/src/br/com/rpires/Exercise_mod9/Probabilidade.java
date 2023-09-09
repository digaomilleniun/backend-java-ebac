package Tests_java_bySteve;

public class Probabilidade {
    public static void main(String[] args) {
        int totalNumeros = 25;
        int numerosParaAcertar = 15;

        double probabilidadeDeNaoAcertar = Math.pow((double)(totalNumeros - 1) / totalNumeros, numerosParaAcertar);

        double probabilidadeDeAcertarPeloMenosUm = 1 - probabilidadeDeNaoAcertar;

        System.out.println("Probabilidade de pelo menos uma pessoa acertar os 15 números: " + probabilidadeDeAcertarPeloMenosUm);
    }
}
