package projetopetshop;

public class Cliente {
	private int codigo;
	private String nome;
	private String endereco;
	private double telefone;
	private String email;
	
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
	public double getTelefone() {
		return telefone;
	}
	public void setTelefone(double telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Dados do cliente
	@Override
	public String toString() {
		return "| Código = " + codigo + " | Nome = " + nome + " | Endereço = " + endereco + " | telefone = " + telefone + " | E-mail = " + email;
	}
	
	
}
