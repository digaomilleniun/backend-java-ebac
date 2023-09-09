package Tests_java_bySteve;

public class Probabilidade {
    public static void main(String[] args) {
        Integer totalNumeros = 25;
        Integer numerosParaAcertar = 15;

        Double probabilidadeDeNaoAcertar = Math.pow((double)(totalNumeros - 1) / totalNumeros, numerosParaAcertar);

        Double probabilidadeDeAcertarPeloMenosUm = 1 - probabilidadeDeNaoAcertar;

        System.out.println("Probabilidade de pelo menos uma pessoa acertar os 15 números: " + probabilidadeDeAcertarPeloMenosUm);
    }
}
