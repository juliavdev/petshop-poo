package projetopetshop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
	
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Animal> listaAnimais = new ArrayList<Animal>();


	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		System.out.println("BEM VINDO AO PET SHOP PATINHAS!");
		System.out.println("O que você quer fazer?\n");
		System.out.println("1. Acessar menu de clientes");
		System.out.println("2. Acessar menu de animais");
		System.out.println("3. Sair do programa\n");
		System.out.println("Digite a opção desejada:");
		
		try {
			int opcao = Utilidades.scanner.nextInt();
		
			switch(opcao){
			case 1:
				MenuClientes.menuClientes();
				break;
			case 2:
				MenuAnimais.menuAnimais();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("\nOpção inválida\n");
				menuPrincipal();
			}
		} catch (InputMismatchException e) {
			Utilidades.scanner = new Scanner(System.in);
			System.out.println("Por favor, digite uma opção válida");
			menuPrincipal();
		}	
	}
	
}
