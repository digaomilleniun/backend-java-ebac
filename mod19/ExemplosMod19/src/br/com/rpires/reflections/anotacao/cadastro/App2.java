package br.com.rpires.reflections.anotacao.cadastro;


import br.com.rpires.reflections.anotacao.cadastro.dao.ClienteMapDAO;
import br.com.rpires.reflections.anotacao.cadastro.dao.IClienteDAO;
import br.com.rpires.reflections.anotacao.cadastro.dao.IProdutoDAO;
import br.com.rpires.reflections.anotacao.cadastro.dao.ProdutoDAO;
import br.com.rpires.reflections.anotacao.cadastro.dao.generic.IGenericDAO;
import br.com.rpires.reflections.anotacao.cadastro.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.domain.Persistente;
import br.com.rpires.reflections.anotacao.cadastro.exception.DadosInvalidosException;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;
import br.com.rpires.reflections.anotacao.cadastro.fabrica.FabricaPersistente;
import br.com.rpires.reflections.anotacao.cadastro.fabrica.Factory;
import br.com.rpires.reflections.anotacao.cadastro.fabrica.IFactory;

import javax.swing.*;

/**
 * @author rodrigo.pires
 *
 * Aplicação de exemplo que simula um cadastro de cliente e produto
 *
 */
public class App2 {

    private static IClienteDAO iClienteDAO;
    private static IProdutoDAO iProdutoDAO;

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

    /**
     * Método que valida e decide qual método de CRUD irá ser chamado
     *
     * @param opcao selecionada para tratar os registros: <br>
     * <b>
     *      <ol>
     *          <li> - Para cadastrar dados</li>
     *          <li> - Para consultar dados</li>
     *          <li> - Para excluir dados</li>
     *          <li> - Para atualizar dados</li>
     *          <li> - Para sair da aplicação</li>
     *      </ol>
     * </b>
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     */
    private static void executarOpcoes(String opcao, String opcaoMenuGeral) {
        try {
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
        } catch(DadosInvalidosException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE VALIDAÇÃO DE DADOS",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * Método que trata a atualização dos dados
     *
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     */
    private static void executarOpcaoAtualizar(String opcaoMenuGeral) {
        String dados = JOptionPane.showInputDialog(null,
                "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        try {
            iClienteDAO.alterar(cliente);
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } catch (TipoChaveNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SISTEMA. CONTATE O ADMINISTRADOR DESTE SISTEMA", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método que trata a exclusão dos dados
     *
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     */
    private static void executarOpcaoExcluir(String opcaoMenuGeral) {
        String msg = opcaoMenuGeral.equals("1") ? "Digite o CPF" : "Digite o código";
        String dados = JOptionPane.showInputDialog(null,
                msg,
                "Exclusão de dados", JOptionPane.INFORMATION_MESSAGE);
        getDAO(opcaoMenuGeral).excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que trata a consulta dos dados
     *
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     */
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

    /**
     * Método que trata o cadstro dos dados
     *
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     * @throws DadosInvalidosException quando os dados estão inválidos
     */
    private static void executarOpcaoCadastrar(String opcaoMenuGeral) throws DadosInvalidosException {
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

    /**
     * Inicializa os acessos aos registros do banco de dados.
     */
    private static void inicializarDAO() {
        iClienteDAO = new ClienteMapDAO();
        iProdutoDAO = new ProdutoDAO();
    }

    /**
     * Método que retorna a instância correta do DAO para o tipo de dados desejado ou selecionado
     *
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     * @return <code>IGenericDAO</code> interface genérica que contém os métodos de CRUD
     */
    public static IGenericDAO getDAO(String opcaoMenuGeral) {
        if ("1".equals(opcaoMenuGeral)) {
            return iClienteDAO;
        } else {
            return iProdutoDAO;
        }
    }

    /**
     * Método que executa a consulta ao banco de dados
     *
     * @param dados valor a ser consultado
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     * @return retorna o objeto <b>Persistente</b> que é pai de todas as entidades da aplicação
     */
    private static Persistente consultar(String dados, String opcaoMenuGeral) {
        return getDAO(opcaoMenuGeral).consultar(Long.valueOf(dados));
    }

    /**
     * Método que trata o cadastro dos dados no banco de dados
     *
     * @param dados valor a ser cadsatrado
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     * @throws DadosInvalidosException quando os dados estão inválidos
     */
    private static void cadastrar(String dados, String opcaoMenuGeral) throws DadosInvalidosException {
        String[] dadosSeparados = dados.split(",");
        Persistente persistente = criarObjetoConcreto(dadosSeparados, opcaoMenuGeral);
        Boolean isCadastrado = null;
        try {
            isCadastrado = cadastrarObjeto(opcaoMenuGeral, persistente);
            if (isCadastrado) {
                JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Dados já se encontra cadastrado", "Erro",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (TipoChaveNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SISTEMA. CONTATE O ADMINISTRADOR DESTE SISTEMA", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }


    }

    /**
     * Método que executa o cadastro dos dados no banco de dados
     *
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     * @param persistente objeto pai que representa todas as entidades da aplicação
     * @return
     */
    private static Boolean cadastrarObjeto(String opcaoMenuGeral, Persistente persistente) throws TipoChaveNaoEncontradaException {
        return getDAO(opcaoMenuGeral).cadastrar(persistente);
    }

    /**
     * Método que cria uma fábrica de fábrica de objetos
     *
     * @param dadosSeparados Dados a serem cadastrados no banco de dados
     * @param opcaoMenuGeral Opção selecionada no menu inicial da aaplicação - <b>1 para cliente e 2 para produto</b>
     * @return Retorna o objeto <b>Persistente</b> que é pai de todas as entidades da aplicação
     * @throws DadosInvalidosException quando os dados estão inválidos
     */
    private static Persistente criarObjetoConcreto(String[] dadosSeparados, String opcaoMenuGeral) throws DadosInvalidosException {
        IFactory factory = new Factory();
        FabricaPersistente fabricaPersistente = factory.criarFabrica(opcaoMenuGeral);
        return fabricaPersistente.criarObjeto(dadosSeparados);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
                || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoMenuValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo: ", "Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isExcluir(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

}
