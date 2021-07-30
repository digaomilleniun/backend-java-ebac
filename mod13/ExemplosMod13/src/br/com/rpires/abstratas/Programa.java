package br.com.rpires.abstratas;

/**
 * @author rodrigo.pires
 */
public class Programa {

    public static void main(String args[]) {
        Assalariado empregado = new Assalariado();
        empregado.setCpf("1");
        empregado.setNome("Rodrigo");
        empregado.setSobrenome("Pires");
        empregado.setSalario(100d);
        imprimir(empregado);

        Comissionado comissionado = new Comissionado();
        comissionado.setCpf("2");
        comissionado.setNome("Rodrigo2");
        comissionado.setSobrenome("Pires");
        comissionado.setTotalVenda(2000d);
        comissionado.setTotalComissao(0.1d);
        imprimir(comissionado);

        Horista horista = new Horista();
        horista.setCpf("23");
        horista.setNome("Rodrigo23");
        horista.setSobrenome("Pires");
        horista.setPrecoHora(100d);
        horista.setTotalHoraTrabalhada(60d);
        imprimir(horista);
    }

    public static void imprimir(Empregado empregado) {
        if (empregado instanceof Horista) {
            Horista hor = (Horista) empregado;
            System.out.println(hor.getPrecoHora());
        }
        empregado.imprimirSobrenome();
        empregado.imprimirValores();
        System.out.println(empregado.getNome() + " Tem salário: " + empregado.vencimento());
    }
}
