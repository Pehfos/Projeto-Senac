package dao;

import java.util.Scanner;

import View.Screen;
import controller.Controller;



public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		Screen screen = new Screen();
		
		int userInput = 0;
		
		do {
			screen.exibirMenu();
			
			userInput = scanner.nextInt();
			
			controller.verificarInput(userInput);
			
		} while (userInput != 0);
	}

}
