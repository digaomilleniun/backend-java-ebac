package br.com.rpires.pacote2;


import br.com.rpires.Cliente;
import br.com.rpires.ItemVenda;
import br.com.rpires.pacote1.Classe1;
import br.com.rpires.pacote1.Classe2;


/**
 * @author Steve.Vaz
 *
 *
 */
public class Classe3 extends Classe2 {

    /**
     * Comentário do que o método faz
     *
     * @param args  asdsada
     */
    @SuppressWarnings("deprecation")
	public static void main(String args[]) {
        new Classe1();
        Cliente cliente = new Cliente();
        cliente.retornarNomeCliente();
        cliente.getValorTotal();

        new ItemVenda();


    }

    /**
     * @deprecated
     */
    public void teste() {

    }
}
