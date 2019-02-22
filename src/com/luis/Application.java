package com.luis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		int choice=1;
		int choiceQuery;
		Validador validador = new Validador();
		Hipermercado hipermercado = new Hipermercado();
		Consulta consulta = new Consulta(hipermercado, validador);

	   		
		List<Hipermercado> arraylist = new ArrayList<Hipermercado>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Carregue o ficheiro dos clientes\n2. Carregue o ficheiro dos produtos\n3. Carregue o ficheiro das compras\n4. Consulte as queries\n5. Terminar opera��o.");
				
		do {
			System.out.println("");
			System.out.print("Escolha uma op��o:");
			
	//		choice = sc.nextInt();
			
			System.out.println("");

			String strCurrentLine;
		
			switch (choice) {

			case 1:
				System.out.println("Foi escolhida a op��o 1: \n");
		
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichClientes.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						if(validador.validacaoCliente(strCurrentLine)!=null){
							Ccliente ccliente = validador.validacaoCliente(strCurrentLine);
							hipermercado.addCcliente(ccliente);
						}
					}
					objReader.close();

					arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro de clientes foi carregado.");
					choice++;
					
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.println("Foi escolhida a op��o 2: \n");
		
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichProdutos.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {

						if(validador.validacaoProduto(strCurrentLine)!=null){
							Cproduto cproduto = validador.validacaoProduto(strCurrentLine);
							hipermercado.addCproduto(cproduto);
						}
					}
					objReader.close();

					arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro dos produtos foi carregado.");
					choice++;

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Foi escolhida a op��o 3: \n");
	
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {

						if (validador.validacao(strCurrentLine) != null) {
							Compra compra = validador.validacao(strCurrentLine);
							if(compra == null){
								continue;
							}
							hipermercado.addCompra(compra);
		   
						}
					}
				
					objReader.close();
					arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro das compras foi carregado.");
					choice++;
		
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.println("Foi escolhida a op��o 4:Queries \n");
				
				System.out.println("Query 01 - N�mero total de compras por m�s.");
				System.out.println("Query 02 - Factura��o total por m�s e o total Global.");
				System.out.println("Query 03 - N�mero distintos clientes que compraram em cada m�s.");
				System.out.println("Query 04 - Total de registos de compras inv�lidos.");
				System.out.println("Query 05 - Lista ordenada com os c�digos dos produtos nunca comprados e respetivo total.");
				System.out.println("Query 06 - Lista Ordenada com os c�digos dos clientes que nunca compraram e seu total.");
				System.out.println("Query 07 - Dado um m�s V�lido, � determinado o n�mero total de compras e o total de clientes distintos que as realizaram.");
				System.out.println("Query 08 - Dado um c�digo de cliente, � determinado, para cada m�s, quantas compras fez, quantos produtos distintos comprou e quanto gastou. � apresentado tamb�m o total anual faturado ao cliente.");
				System.out.println("Query 09 - Dado um c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado, por quantos clientes diferentes e o total faturado.");
				System.out.println("Query 10 - Dado o c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado em modo N e em modo P e respetivas factura��es.");
				System.out.println("Query 11 - Dado o c�digo de um cliente, � determinado a lista de c�digos que mais comprou, e quantos, ordenada por ordem descrescente de quantidade e para quantidades iguais, por ordem alfab�tica dos c�digos");
				System.out.println("Query 12 - � determinado o conjunto dos produtos mais vendidos em todo o ano, indicando o n�mero total de distintos clientes que o compraram.");
				System.out.println("Query 13 - � determinado os clientes que compraram um maior n�mero de diferentes produtos indicando quantos.");
				
				do {
					
					System.out.print("\nEscolha uma query:");
					
					choiceQuery = sc.nextInt();
					
					System.out.println("");

					switch (choiceQuery) {

					case 1:
						System.out.println("Foi escolhida a query 1 - N�mero Total de Compras por m�s: \n");
						consulta.totalComprasMes();
						break;

					case 2:
						System.out.println("Foi escolhida a query 2 - Valor total das compras/vendas e total global\n");	
						consulta.totalGlobal();
						break;
						
					case 3:
						System.out.println("Foi escolhida a query 3 - N�mero distintos de clientes que compraram cada m�s\n");
						consulta.clientesDistintos();
						break;
					
					case 4:	
						System.out.println("Foi escolhida a query 4 - Total de registos de compras inv�lidas\n");
						consulta.comprasInvalidas();
						break;
						
					case 5:
						System.out.println("Foi escolhida a query 5 - Lista Ordenada com os c�digos dos produtos nunca comprados e o respectivo total\n");
					    consulta.produtosNaoComprados();
						break;
						
					case 6:
						System.out.println("Foi escolhida a query 6 - Lista Ordenada com os c�digos dos clientes que nunca compraram e seu total\n");
					    consulta.clientesNuncaCompraram();
					    break;
					
					case 7:
						System.out.println("Foi escolhida a query 7 - Dado um m�s V�lido, � determinado o n�mero total de compras e o total de clientes distintos que as realizaram.");
						consulta.numeroComprasEclientesPorMes();
						break;
					
					case 8:
						System.out.println("Foi escolhida a query 8 - Dado um c�digo de cliente, � determinado, para cada m�s, quantas compras fez, quantos produtos distintos comprou e quanto gastou. � apresentado tamb�m o total anual faturado ao cliente."); 
						consulta.codigoClienteParaMes();
						break;
					
					case 9:	
						System.out.println("Foi escolhida a query 9 - Dado um c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado, por quantos clientes diferentes e o total faturado.");
						consulta.codigoProdutoMesaMes();
						break;
						
					case 10:
						System.out.println("Foi escolhida a query 10 - Dado o c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado em modo N e em modo P e respetivas factura��es.");
						consulta.codigoProdutoNP();
						break;
					
					
					case 11:
						System.out.println("Foi escolhida a query 11 - Dado o c�digo de um cliente, � determinado a lista de c�digos que mais comprou, e quantos, ordenada por ordem descrescente de quantidade e para quantidades iguais, por ordem alfab�tica dos c�digos");
						consulta.clienteListaProdutos();
					    break;
					
					case 12:
						System.out.println("Foi escolhida a query 12 - � determinado o conjunto dos produtos mais vendidos em todo o ano, indicando o n�mero total de distintos clientes que o compraram.");
					    consulta.conjuntoXprodutos();
					    break;
					    
					case 13:
						System.out.println("Foi escolhida a query 13 - � determinado os clientes que compraram um maior n�mero de diferentes produtos indicando quantos.");
					    consulta.clientesDiferentesProdutos();
					    break;
					}
					
			
				}while(choiceQuery<10);	
							
				break;
	
			case 5:	
				System.out.println("Opera��o terminada");
				sc.close();
				System.exit(0);
					
			default:
				System.out.println("N�o escolheu op��o nenhuma");
			}

		} while (choice < 10);
		
	}
}
	

		
