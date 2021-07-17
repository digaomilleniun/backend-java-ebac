package br.com.rpires.pacote2;

import br.com.rpires.Cliente;
import br.com.rpires.ItemVenda;
import br.com.rpires.pacote1.Classe1;
import br.com.rpires.pacote1.Classe2;

import java.util.Iterator;

/**
 * @author rodrigo.pires
 *
 *
 */
public class Classe3 extends Classe2 {

    /**
     * Comentário do que o método faz
     *
     * @param args  asdsada
     */
    public static void main(String args[]) {
        Classe1 class1 = new Classe1();
        Cliente cliente = new Cliente();
        cliente.retornarNomeCliente();
        cliente.getValorTotal();

        ItemVenda item = new ItemVenda();


    }

    /**
     * @deprecated
     */
    public void teste() {

    }
}
