package Exercise_mod13;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<pessoa_fisica> pessoasFisicas = new ArrayList<>();
        List<pessoa_juridica> pessoasJuridicas = new ArrayList<>();

        System.out.println("Insira seus dados para calcular o imposto de renda.");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite 'F' para pessoa física ou 'J' para pessoa jurídica: ");
        char tipo = sc.next().charAt(0);

        if (tipo == 'F' || tipo == 'f') {
            System.out.print("Digite a alíquota (exemplo: 20% para 20): ");
            int aliquotaPercentual = sc.nextInt();
            System.out.print("Digite sua renda bruta: ");
            double rendaBruta = sc.nextDouble();
            System.out.print("Digite as deduções: ");
            double deducoes = sc.nextDouble();

            // Cálculo do imposto de renda de pessoa física
            double IRPF = (rendaBruta * aliquotaPercentual / 100) - deducoes;

            pessoa_fisica pessoa = new pessoa_fisica(nome, (int) aliquotaPercentual, rendaBruta, deducoes, 0, IRPF);
            pessoasFisicas.add(pessoa);

            // Exibe o valor do imposto de renda da pessoa física com 2 casas decimais
            System.out.printf("Imposto de Renda Pessoa Física de %s: %.3f%n", nome, IRPF);
        } else if (tipo == 'J' || tipo == 'j') {
            System.out.print("Digite o lucro tributável: ");
            double lucroTributavel = sc.nextDouble();
            System.out.print("Digite a alíquota (exemplo: 20% para 20): ");
            int aliquotaPercentual = sc.nextInt();
            System.out.print("Digite as deduções: ");
            double deducoes = sc.nextDouble();
            System.out.print("Digite a parcela a deduzir: ");
            double parcelaAdeduzir = sc.nextDouble();

            double IRPJ = ((lucroTributavel * aliquotaPercentual / 100) - deducoes - parcelaAdeduzir);

            pessoa_juridica pessoa = new pessoa_juridica(nome, (int) aliquotaPercentual, 0, deducoes, parcelaAdeduzir, IRPJ);

            pessoasJuridicas.add(pessoa);

            // Exibe o valor do imposto de renda da pessoa jurídica com 2 casas decimais
            System.out.printf("Imposto de Renda Pessoa Jurídica de %s: %.3f%n", nome, IRPJ);
        }

        sc.close();
    }
}
