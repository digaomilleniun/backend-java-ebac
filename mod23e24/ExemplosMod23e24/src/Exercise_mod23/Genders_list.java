package Exercise_mod23;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

class Pessoa {
    private String nome;
    private String sexo;
    private String nacionalidade;

    public Pessoa() {
    	
    }
    
    public Pessoa(String nome, String sexo, String nacionalidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}

public class Genders_list {
	@Test
    public void main() {
		
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria", "Feminino", "Brasileira"));
        pessoas.add(new Pessoa("João", "Masculino", "Brasileiro"));
        pessoas.add(new Pessoa("Sophia", "Feminino", "Espanhola"));
        pessoas.add(new Pessoa("Lucas", "Masculino", "Espanhol"));
        pessoas.add(new Pessoa("Isabella", "Feminino", "Italiana"));
        pessoas.add(new Pessoa("Liam", "Masculino", "Italiano"));

        // Usando Stream e Expressão Lambda para filtrar apenas as mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> pessoa.getSexo().equals("Feminino"))
                .collect(Collectors.toList());

        // Imprimir o nome, sexo e nacionalidade das mulheres
        mulheres.forEach(pessoa -> System.out.println("Nome: " 
             + pessoa.getNome() + ", Sexo: " + pessoa.getSexo() 
             + ", Nacionalidade: " 
             + pessoa.getNacionalidade()));
    }
}
