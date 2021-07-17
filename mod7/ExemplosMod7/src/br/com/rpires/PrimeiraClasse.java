package br.com.rpires;

/**
 * @author rodrigo.pires
 */
public class PrimeiraClasse {

    public static void main(String args[]) {
        System.out.println("Olá Rodrigo");
        Cliente cliente = new Cliente();
        cliente.cadastrarEndereco("Rua 1");
        cliente.setCodigo(1);
        System.out.println(cliente.getCodigo());
        //cliente.imprimirEndereco();
        System.out.println(cliente.retornarNomeCliente());
        System.out.println(cliente.getValorTotal());
    }
}
