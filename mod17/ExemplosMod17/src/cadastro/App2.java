package cadastro;

import javax.swing.JOptionPane;

import br.com.rpires.dao.ClienteDAO;
import cadastro.dao.ProdutoDAO;
import cadastro.dao.generic.GenericDAO;
import cadastro.dao.generic.IGenericDAO;
import cadastro.domain.Cliente;
import cadastro.domain.Persistente;
import cadastro.domain.Produto;
import cadastro.fabrica.FabricaPersistente;
import cadastro.fabrica.Factory;
import cadastro.fabrica.IFactory;

public class App2 {

    private static ClienteDAO<?, ?> iClienteDAO;
    private static GenericDAO<Produto> iProdutoDAO;

    public static void main(String args[]) {
        inicializarDAO();

        String opcaoMenuGeral = JOptionPane.showInputDialog(null,
                "Digite 1 para Cliente ou 2 para Produto", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoMenuValida(opcaoMenuGeral)) {
            if ("".equals(opcaoMenuGeral)) {
                sair();
            }
            opcaoMenuGeral = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para Cliente ou 2 para Produto", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcaoMenuGeral)) {

            String titulo = opcaoMenuGeral.equals("1") ? "Cadastro de Clientes" : "Cadastro de Produtos";

            String opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    titulo, JOptionPane.INFORMATION_MESSAGE);

            executarOpcoes(opcao, opcaoMenuGeral);

            opcaoMenuGeral = JOptionPane.showInputDialog(null,
                    "Digite 1 para Cliente ou 2 para Produto", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void executarOpcoes(String opcao, String opcaoMenuGeral) {
        if (isOpcaoSair(opcao)) {
            sair();
        } else if (isCadastro(opcao)) {
            executarOpcaoCadastrar(opcaoMenuGeral);
        } else if(isConsultar(opcao)) {
            executarOpcaoConsultar(opcaoMenuGeral);
        } else if(isExcluir(opcao)) {
            executarOpcaoExcluir(opcaoMenuGeral);
        } else {
            executarOpcaoAtualizar(opcaoMenuGeral);
        }
    }

    @SuppressWarnings("unchecked")
	private static void executarOpcaoAtualizar(String opcaoMenuGeral) {
        String dados = JOptionPane.showInputDialog(null,
                "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        ((IGenericDAO<Persistente>) iClienteDAO).alterar(cliente);
        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
	private static void executarOpcaoExcluir(String opcaoMenuGeral) {
        String msg = opcaoMenuGeral.equals("1") ? "Digite o CPF" : "Digite o código";
        String dados = JOptionPane.showInputDialog(null,
                msg,
                "Exclusão de dados", JOptionPane.INFORMATION_MESSAGE);
        ((IGenericDAO<Persistente>) getDAO(opcaoMenuGeral)).excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static void executarOpcaoConsultar(String opcaoMenuGeral) {
        String msg = opcaoMenuGeral.equals("1") ? "Digite o CPF" : "Digite o código";

        String dados = JOptionPane.showInputDialog(null,
                msg,
                "Consultar", JOptionPane.INFORMATION_MESSAGE);

        Persistente persistente = consultar(dados, opcaoMenuGeral);
        if (persistente != null) {
            JOptionPane.showMessageDialog(null, "Dado encontrado: " + persistente.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Dado não encontrado: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void executarOpcaoCadastrar(String opcaoMenuGeral) {
        String dados = "";
        if ("1".equals(opcaoMenuGeral)) {
            dados = JOptionPane.showInputDialog(null,
                    "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            dados = JOptionPane.showInputDialog(null,
                    "Digite os dados do produto separados por vígula, conforme exemplo: código e nome",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
        cadastrar(dados, opcaoMenuGeral);
    }

    private static <E, T> void inicializarDAO() {
        iClienteDAO = new ClienteDAO<>();
        iProdutoDAO = new ProdutoDAO();
    }

    public static Object getDAO(String opcaoMenuGeral) {
        if ("1".equals(opcaoMenuGeral)) {
            return iClienteDAO;
        } else {
            return iProdutoDAO;
        }
    }

    @SuppressWarnings("unchecked")
    private static Persistente consultar(String dados, String opcaoMenuGeral) {
        return ((IGenericDAO<Persistente>) getDAO(opcaoMenuGeral)).consultar(Long.valueOf(dados));
    }

    private static void cadastrar(String dados, String opcaoMenuGeral) {
        String[] dadosSeparados = dados.split(",");
        Persistente persistente = criarObjetoConcreto(dadosSeparados, opcaoMenuGeral);
        Boolean isCadastrado = cadastrarObjeto(opcaoMenuGeral, persistente);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Dados já se encontram cadastrados", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private static Boolean cadastrarObjeto(String opcaoMenuGeral, Persistente persistente) {
        return ((GenericDAO<Persistente>) getDAO(opcaoMenuGeral)).cadastrar(persistente);
    }

    private static Persistente criarObjetoConcreto(String[] dadosSeparados, String opcaoMenuGeral) {
        IFactory factory = new Factory();
        FabricaPersistente fabricaPersistente = factory.criarFabrica(opcaoMenuGeral);
        return fabricaPersistente.criarObjeto(dadosSeparados);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

    private static boolean isOpcaoMenuValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo: ", "Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isExcluir(String opcao) {
        return "3".equals(opcao);
    }
}
