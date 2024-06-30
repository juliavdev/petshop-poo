package projetopetshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAnimais {
	
	public static void menuAnimais() {
		Utilidades.limpaTela();
		System.out.println("\nMENU DE ANIMAIS");
		System.out.println("O que você quer fazer?\n");
		System.out.println("1. Listar animais");
		System.out.println("2. Adicionar animal");
		System.out.println("3. Remover animal");
		System.out.println("4. Alterar animal");
		System.out.println("5. Voltar ao menu principal");
		System.out.println("Digite a opção desejada:");
		
		try {
			int opcao = Utilidades.scanner.nextInt();

			switch (opcao) {
			case 1:
				listaAnimais();
				break;

			case 2:
				adicionaAnimal();
				break;

			case 3:
				removerAnimal();
				break;

			case 4:
				alterarAnimal();
				break;

			case 5:
				MenuPrincipal.menuPrincipal();
				break;

			default:
				menuAnimais();
				break;
			}
		}

		catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Comando inválido, digite uma opção válida.");
			menuAnimais();
		}
		menuAnimais();
	}

	private static void verificaCadastraAnimal(Animal animal) {
		try {
			System.out.println("Digite o código:");
			int codigo = Utilidades.scanner.nextInt();

			Animal animalVerificacao = getAnimalPeloCodigo(codigo);
			if(animalVerificacao != null && !animal.equals(animalVerificacao)) {
				System.out.println("Esse cÃ³digo jÃ¡ estÃ¡ sendo utilizado por outro animal.");
				verificaCadastraAnimal(animal);
				return;
			}
			animal.setCodigo(codigo);
			
			Utilidades.scanner.nextLine();
			
			System.out.println("Digite o nome:");
			animal.setNome(Utilidades.scanner.nextLine());

			System.out.println("Digite a especie:");
			animal.setEspecie(Utilidades.scanner.next());

			configuraCliente(animal);
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite um código válido");
			menuAnimais();
		}
		
	}

	private static void configuraCliente (Animal animal) {
		try {
			System.out.println("Digite o código do cliente que é dono deste animal:");
			int codigoCliente = Utilidades.scanner.nextInt();
			
			Cliente cliente = MenuClientes.getClientePeloCodigo(codigoCliente);
			
			if(cliente == null) {
				System.out.println("Não existe nenhum cliente com este código, por favor digite um código válido");
				configuraCliente(animal);
			}
			else {
			animal.setCliente(cliente);}	
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite um código válido");
			menuAnimais();
		}
	}

	private static void alterarAnimal() {
		try {
			System.out.println("Digite o código do animal que deseja alterar:");
			int codigo = Utilidades.scanner.nextInt();
			Animal animal = getAnimalPeloCodigo(codigo);
			if(animal!=null) {
				verificaCadastraAnimal(animal);
			}
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite um código válido");
			menuAnimais();
		}
	}

	private static void removerAnimal() {
		try {
			System.out.println("Digite o código do animal que deseja remover:");
			int codigo = Utilidades.scanner.nextInt();
			Animal animal = getAnimalPeloCodigo(codigo);
			if(animal!=null)
				MenuPrincipal.listaAnimais.remove(animal);
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite um código válido");
			menuAnimais();
		}
}

	private static void adicionaAnimal() {
		Animal animal = new Animal();
		verificaCadastraAnimal(animal);
		MenuPrincipal.listaAnimais.add(animal);
	}
		
	private static void listaAnimais() {
		System.out.println("\n Lista de animais:");
		for(Animal animal : MenuPrincipal.listaAnimais) 
			System.out.println(animal.toString());
	}

	private static Animal getAnimalPeloCodigo(int codigo) {
		for (int i = 0; i < MenuPrincipal.listaAnimais.size(); i++) {
			Animal animal = MenuPrincipal.listaAnimais.get(i);
			if(animal.getCodigo() == codigo) 
				return animal;
		}
		return null;
	}

		
		

	}
