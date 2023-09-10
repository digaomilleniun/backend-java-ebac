package Tests_java_bySteve;

public class Probabilidade {
    public static void main(String[] args) {
        int totalNumeros = Integer.valueOf(25);
        int numerosParaAcertar = Integer.valueOf(15);

        double probabilidadeDeNaoAcertar = Math.pow(Double.valueOf(totalNumeros - 1) / totalNumeros, numerosParaAcertar);

        double probabilidadeDeAcertarPeloMenosUm = Double.valueOf(1 - probabilidadeDeNaoAcertar);

        // Imprimindo a variável probabilidadeDeAcertarPeloMenosUm no tipo primitivo double
        System.out.println("Primitivo: Probabilidade de pelo menos uma pessoa acertar os 15 números: " + probabilidadeDeAcertarPeloMenosUm);
        
        System.out.println();
        
        // Imprimindo a variável probabilidadeDeAcertarPeloMenosUm no tipo wrapper Double
        System.out.println("Wrapper: Probabilidade de pelo menos uma pessoa acertar os 15 números: " + Double.valueOf(probabilidadeDeAcertarPeloMenosUm));
    }
}
