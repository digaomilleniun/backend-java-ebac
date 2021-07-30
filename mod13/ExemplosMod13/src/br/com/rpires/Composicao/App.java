package br.com.rpires.Composicao;

/**
 * @author rodrigo.pires
 */
public class App {

    public static void main(String aargs[]) {
        Banco banco = new Banco();
        banco.setCodigo(10L);
        banco.setNome("Banco Pires");

        ContaCorrente cc = new ContaCorrente();
        cc.setBanco(banco);
        cc.setSaldo(10d);

        ContaPoupanca cp = new ContaPoupanca();
        cp.setBanco(banco);
        cp.setSaldo(10d);

        banco.add(cc);
        banco.add(cp);

        Banco banco2 = new Banco();
        banco.setCodigo(10L);
        banco.setNome("Banco Pires2");
    }
}
