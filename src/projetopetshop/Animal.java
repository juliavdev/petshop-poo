package projetopetshop;

public class Animal {
	
	private int codigo;
	private String nome;
	private String especie;
	private Cliente cliente;
	

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



	public String getEspecie() {
		return especie;
	}



	public void setEspecie(String especie) {
		this.especie = especie;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	// Dados do animal
	@Override
	public String toString() {
		return "| Código = " + codigo + " | Nome = " + nome + " | Espécie = " + especie + " | Dono = " + cliente.getNome();
	};
	
	
}
