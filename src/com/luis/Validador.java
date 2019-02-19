package com.luis;

import java.util.ArrayList;
import java.util.List;

public class Validador {
	private Compra compra;
	private static int fields = 6;
	private static int productSize = 6;
	private static int clientSize = 5;
	
	List<String> comprasInvalidas;
	public Validador(){
		super();
		this.comprasInvalidas = new ArrayList<>();
	}
	
	public Compra validacao(String strCurrentLine){
		
		if(strCurrentLine == null)
			return null;
		
		String[] lineSplitter = strCurrentLine.split(" ");

		if (lineSplitter.length == fields) {
			
			compra = new Compra();
			
			String valProduto = ValidarProduto(lineSplitter[0]);
			if(valProduto == null) {
				comprasInvalidas.add(strCurrentLine);
				return null;
			}
			compra.setIdProduto(valProduto);
			
			double valPreco = ValidarPreco(lineSplitter[1]);
			if(valPreco <= 0){
				return null;
			}
			compra.setPreco(valPreco);
				
			int valQuantidade = ValidarQuantidade(lineSplitter[2]);
			if(valQuantidade<=0){
				return null;
			}
			compra.setQuantidade(valQuantidade);
			
			String valPromo = ValidarPromo(lineSplitter[3]);
			if(valPromo == null){
				return null;
			}
			compra.setPromo(valPromo);
			
			String valCliente = ValidarCliente(lineSplitter[4]);
			if(valCliente == null){
				return null;
			}
			compra.setIdCliente(valCliente);
			
			int valMes = ValidarMes(lineSplitter[5]);
			if(valMes <=0){
				return null;
			}
			compra.setMes(valMes);
		    
		    return compra;
			
		} else {
			System.out.println("O campo lido � inv�lido");
			System.out.println(" "); 
			return null;
		}
	}	

	public String ValidarCliente(String string) {

		if (string.length() == clientSize) {

			String sub1 = string.substring(0, 2);
			String sub2 = string.substring(2);

			if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
			
				return string;

			} else {
		
				return null;
			}
		} else {

			return null;
		}
	}
	
	public double ValidarPreco(String string) {

		double preco = Double.valueOf(string);
		
		if (preco>0) {
			
			return preco;

		} else {
			
			return 0;
		}
	}
	
	public int ValidarQuantidade(String string) {
		
		int quantidade = Integer.valueOf(string);
		
		if(quantidade>0){
			
			return quantidade;	
		}	
		else{
	 		
			return 0;
		}	
	}
	
	public String ValidarPromo(String string) {

		if(string.length()==1 && (string.equals("N") || string.equals("P"))){
		
			return string;                            
			
		}else{
			
			return null;
		}		
	}

	public String ValidarProduto(String produto) {
	
		if(produto == null)
			return null; 
		
		if (produto.length() == productSize) {

			String sub1 = produto.substring(0, 2);
			String sub2 = produto.substring(2);

			if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
				
				return produto;
				
			} else {
			
				return null;
			}
		} else {
			
			return null;
		}
	}
	
	public int ValidarMes(String string) {

		int mes = Integer.valueOf(string);

		if (mes > 0 && mes <= 12) {
			
			return mes;
		} else {
		
			return 0;
		}
	}
	
	public Ccliente validacaoCliente(String strCurrentLine){
		
		Ccliente ccliente = new Ccliente();

		if (strCurrentLine.length() == clientSize) {

			String sub1 = strCurrentLine.substring(0, 2);
			String sub2 = strCurrentLine.substring(2);

			if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
				
				ccliente.setIdCliente(strCurrentLine);
				return ccliente;

			} else {
			
				return null;
			}
		} else {

			return null;
		}
	}
	
	public Cproduto validacaoProduto(String strCurrentLine){
		
		Cproduto cproduto = new Cproduto();
		
		if (strCurrentLine.length() == productSize) {

			String sub1 = strCurrentLine.substring(0, 2);
			String sub2 = strCurrentLine.substring(2);

			if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
			
				cproduto.setIdProduto(strCurrentLine);
				return cproduto;
				
			} else {
				
				return null;
			}
		} else {
			
			return null;
		}
	}
}
	
	
	
	
	


