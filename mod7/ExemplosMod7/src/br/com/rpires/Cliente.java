package br.com.rpires;

/**
 * @author rodrigo.pires
 *
 * @class br.com.rpires.Cliente
 * @see br.com.rpires.Venda
 *
 * @version 2.0
 */
public class Cliente {

    private int codigo;

    private String nome;

    private String endereco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void cadastrarEndereco(String endereco) {
        setEndereco(endereco);
    }

    public void imprimirEndereco() {
        System.out.println(this.endereco);
    }

    /**
     * Você pode <b>também</b> incluir uma <i>lista</i>:
     * <ol>
     *   <li>elemento 1</li>
     *   <li>elemento 2</li>
     *   <li>elemento 3</li>
     * </ol>
     * e hiperlinks : {@link br.com.rpires.Cliente#retornarNomeCliente()}
     *
     * <br/>
     *
     * <code>1+1=2</code>
     *
     * @see <a href="http://google.com" target="_top">http://google.com</a>.
     *
     * @since version2
     * @version 1.0
     */
    public String retornarNomeCliente() {
        return "Endereco do Rodrigo";
    }

    /**
     *
     *
     * Método que faz o calculo do valor total
     *
     * @return retorna o valor total
     *
     * @deprecated
     * @see int getValorTotal(int count)
     */
    public int getValorTotal() {
        return 20;
    }

    /**
     *  Método que irá calcular o valor total
     * @param count parâmetro
     * @return retorna o calculo
     * @throws Exception Erro no calculo
     */
    public int getValorTotal(int count) throws Exception{
        return 20;
    }
}
