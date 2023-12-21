package exercise_mod29;

public class Cliente_1 {
    private String nome;
    private String email;
    private String telefone;
    private int id;
	private int ClienteId;

	public Cliente_1(String nome, String email, String telefone, int id) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
    }

    // getters e setters
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public int getClienteId() {
		return ClienteId;
    }
}

