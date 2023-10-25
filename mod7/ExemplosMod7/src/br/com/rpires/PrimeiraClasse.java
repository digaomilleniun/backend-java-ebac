package br.com.rpires;

/**
 * @author Steve.Vaz
 */
public class PrimeiraClasse {

	 @SuppressWarnings("deprecation")
	public void cadastrarEndereco(String[] args) {
       
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
