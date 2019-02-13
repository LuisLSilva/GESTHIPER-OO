package com.luis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Validador {
	
	String strCurrentLine;
	List<String> listaClientes = new ArrayList<String>();
	List<String> listaPrecos = new ArrayList<String>();
	List<String> listaQuantidade = new ArrayList<String>();
	List<String> listaTipo = new ArrayList<String>();
	List<String> listaProduto = new ArrayList<String>();
	List<String> listaMes = new ArrayList<String>();
	int fields = 6;
	
	public Validador(){
		super();
	}
	
	public void carregarFicheiro(){
		try {
			BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] lineSplitter = strCurrentLine.split(" ");

				if (lineSplitter.length == fields) {
					listaClientes.add(lineSplitter[0]);
					listaPrecos.add(lineSplitter[1]);
					listaQuantidade.add(lineSplitter[2]);
					listaTipo.add(lineSplitter[3]);
					listaProduto.add(lineSplitter[4]);
					listaMes.add(lineSplitter[5]);

				} else {
					System.out.println("O campo lido � inv�lido");
				}
				// System.out.println(strCurrentLine);
			}
			objReader.close();
			validacao();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void validacao(){
		validarClientes();
		validarPreco();
		validarQuantidade();
		validarPN();
		validarProdutos();
		validarMes();
	}
	
	public void validarClientes() {
		
		for(int i=0; i<listaClientes.size(); i++){
			String clienteTemp =(listaClientes.get(i));
			
			if(clienteTemp.length()==6){
			
				String sub1 = clienteTemp.substring(0, 2);
				String sub2 = clienteTemp.substring(2);
		
				if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
					System.out.println("O id do cliente "+clienteTemp+" � v�lido");
					System.out.println(" ");
				}else{
					System.out.println("O id do cliente "+clienteTemp+" � inv�lido");
					System.out.println(" "); 
				}
			}else{
				System.out.println("O id do cliente "+clienteTemp+" � inv�lido");
				System.out.println(" ");
			}	
		}
	}
	
	public void validarPreco() {
		
		for(int i=0; i<listaPrecos.size(); i++){
			double preco = Double.valueOf(listaPrecos.get(i));
			
			if(preco>0){
				System.out.println("O pre�o "+preco+" � v�lido!!!");
				System.out.println(" "); 
			}	
			else{
				System.out.println("O pre�o "+preco+" � inv�lido!!!");
				System.out.println(" "); 
			}	
		}
	}
	
	public void validarQuantidade() {
		
		for(int i=0; i<listaQuantidade.size(); i++){
			int quantidade = Integer.valueOf(listaQuantidade.get(i));
			
			if(quantidade>0){
				System.out.println("A quantidade "+quantidade+" � v�lida!!!");
				System.out.println(" "); 
			}	
			else{
				System.out.println("A quantidade "+quantidade+" � inv�lida!!!");
				System.out.println(" "); 
			}	
		}	
	}
	
	private void validarPN() {
		
		for(int i=0; i<listaTipo.size(); i++){
			String tipoTemp =(listaTipo.get(i));
			
			if(tipoTemp.length()==1 && (tipoTemp.equals("N") || tipoTemp.equals("P"))){
				System.out.println("O tipo do produto "+ tipoTemp + " � v�lido!");
				System.out.println(" "); 
			}else{
				System.out.println("O tipo do produto "+ tipoTemp + " � inv�lido!");
				System.out.println(" "); 
			}	
		}
	}
	
	public void validarProdutos() {
		
		for(int i=0; i<listaProduto.size(); i++){
			String produtoTemp =(listaProduto.get(i));
		
			if(produtoTemp.length()==5){
			
				String sub1 = produtoTemp.substring(0, 2);
				String sub2 = produtoTemp.substring(2);
		
				if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
					System.out.println("O id do produto "+ produtoTemp + "� v�lido!");
					System.out.println(" "); 
				}else{
					System.out.println("O id do produto "+ produtoTemp + "� inv�lido!");
					System.out.println(" "); 
				}
			}else{
				System.out.println("O id do produto "+ produtoTemp + "� inv�lido!");
				System.out.println(" "); 
			}
		}
	}

	public void validarMes() {
		
		for(int i=0; i<listaMes.size(); i++){
			int mes = Integer.valueOf(listaMes.get(i));
		
			if(mes>0 && mes<=12){
				System.out.println("O M�s "+mes+" � v�lido!!!");
				System.out.println(" "); 
			}	
			else{
				System.out.println("O M�s "+mes+" � inv�lido!!!");
				System.out.println(" "); 
			}
		}
	}
}
	
	
	
	
	
	
	
	


