package com.luis;

import java.util.Scanner;

public class Application {

	Hipermercado hipermercado;
	static Validador validador;
	
	public static void main(String[] args) {
	
		System.out.print("Escolha uma op��o:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		System.out.println("");
		
		switch(choice){
			case 1:
				 System.out.println("Escolheu a op��o 1");
				 validador = new Validador();	
				 validador.loadFile();
				 break;
				 
			case 2:
				 System.out.println("Escolheu a op��o 2");
				 break;
			
			case 3:
				 System.out.println("Escolheu a op��o 3");
				 break;
			
			default:
				 System.out.println("N�o escolheu op��o nenhuma");
			}
		
	}

}
