package projetopetshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuClientes {
	
	public static void menuClientes() {
		Utilidades.limpaTela();
		System.out.println("\nMENU DE CLIENTES");
		System.out.println("O que você quer fazer?\n");
		System.out.println("1. Listar clientes");
		System.out.println("2. Adicionar cliente");
		System.out.println("3. Remover cliente");
		System.out.println("4. Alterar cliente");
		System.out.println("5. Voltar ao menu principal");
		System.out.println("Digite a opção desejada:");
		
		try {
			int opcao = Utilidades.scanner.nextInt();

			switch (opcao) {
			case 1:
				listaClientes();
				break;

			case 2:
				adicionaCliente();
				break;

			case 3:
				removerCliente();
				break;

			case 4:
				alterarCliente();
				break;

			case 5:
				MenuPrincipal.menuPrincipal();
				break;

			default:
				menuClientes();
				break;
			}
		}

		catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Comando inválido, digite uma opção válida.");
			menuClientes();
		}
		menuClientes();
	}

	private static void verificaCadastra(Cliente cliente) {
		
		try {
			System.out.println("Digite o código:");
			
			int codigo = Utilidades.scanner.nextInt();

			Cliente clienteVerificacao = getClientePeloCodigo(codigo);
			if(clienteVerificacao != null && !cliente.equals(clienteVerificacao)) {
				System.out.println("Esse código já está sendo utilizado por outro cliente.");
				verificaCadastra(cliente);
				return;
			}
			cliente.setCodigo(codigo);
			
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, utilize apenas números inteiros como código");
			menuClientes();
		}
			
			System.out.println("                  ");
			
			System.out.println("Digite o nome do cliente:");
			Utilidades.scanner.nextLine();
			cliente.setNome(Utilidades.scanner.nextLine());

			try {
				System.out.println("Digite o telefone:");
				cliente.setTelefone(Utilidades.scanner.nextDouble());
			} catch (InputMismatchException e) {
				Utilidades.scanner = new Scanner(System.in);
				System.out.println("Por favor, utilize apenas números inteiros como telefone");
				menuClientes();
			}
			
			System.out.println("Digite o email:");
			cliente.setEmail(Utilidades.scanner.next());
			
			Utilidades.scanner.nextLine();
			
			System.out.print("Digite o endereÃ§o:");
			cliente.setEndereco(Utilidades.scanner.nextLine());
			
		

	}


	private static void alterarCliente() {
		try {
			System.out.println("Digite o código do cliente que deseja alterar:");
			int codigo = Utilidades.scanner.nextInt();
			Cliente cliente = getClientePeloCodigo(codigo);
			if(cliente!=null) {
				verificaCadastra(cliente);
			}
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite um código válido");
			menuClientes();
		}
	}

	private static void removerCliente() {
		try {
			System.out.println("Digite o código do cliente que deseja remover:");
			int codigo = Utilidades.scanner.nextInt();
			Cliente cliente = getClientePeloCodigo(codigo);
			if(cliente!=null)
				MenuPrincipal.listaClientes.remove(cliente);
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite um código válido");
			menuClientes();
		}
	}

	private static void adicionaCliente() {
		Cliente cliente = new Cliente();
		verificaCadastra(cliente);
		MenuPrincipal.listaClientes.add(cliente);
		//Classe.array.adicionar
	}
		
	private static void listaClientes() {
		System.out.println("\n Lista de clientes:");
		for(Cliente cliente : MenuPrincipal.listaClientes) 
			System.out.println(cliente.toString());
	}

	public static Cliente getClientePeloCodigo(int codigo) {
		for (int i = 0; i < MenuPrincipal.listaClientes.size(); i++) {
			Cliente cliente = MenuPrincipal.listaClientes.get(i);
			if(cliente.getCodigo() == codigo) 
				return cliente;
		}
		return null;
	}

		
		

	}
