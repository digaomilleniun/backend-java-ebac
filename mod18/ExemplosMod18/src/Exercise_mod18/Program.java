package Exercise_mod18;


public class Program {
    public static void main(String[] args) {
       
    	if (Produto.class.isAnnotationPresent(Tabela.class)) {
            Tabela tabelaAnnotation = Produto.class.getAnnotation(Tabela.class);
            System.out.println("Nome da tabela: " + tabelaAnnotation.nome());
        } else {
            System.out.println("A anotação de tabela não está presente na classe Produto.");
        }
    }
}
