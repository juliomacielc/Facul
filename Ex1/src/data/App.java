package data;

import java.util.Scanner;

public class App {
	static Scanner sc = new Scanner (System.in);
	static Data datas[] = new Data[20];  
	static int quantidadeDatas = 0;
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		System.out.println("Escolha uma das opções:\n"
				+ "1 - Digitar data (DD/MM/YYYY)\n"
				+ "2 - Inicializar com método construtor Padrão\n"
				+ "3 - Fazer operação com datas");
		int opcao = sc.nextInt();
		switch(opcao){
			case 1:
				dataDigitada();
				break;
			case 2:
				construtorVazio();
				break;
			case 3:
				operacoes();
				break;
			default:
				System.out.println("Opção Inválida, digite novamente:\n");
				menu();
		}
	}
	
	public static void dataDigitada() {
		System.out.println("\nDigite a data no formato DD/MM/YYYY");
		String dataCompleta[] = sc.next().split("/");
		int data[] = converterData(dataCompleta);
		datas[quantidadeDatas] = new Data(data[0], data[1], data[2]);
		System.out.println("Data gerada: "+datas[quantidadeDatas].toString()+ "\n");
		quantidadeDatas++;
		menu();
	}

	private static int[] converterData(String[] data) {
		int aux [] = new int[3]; 
		for(int i = 0; i<data.length; i++) {
			 aux[i]=Integer.parseInt(data[i]);
		 }
		return aux;
	}

	private static void construtorVazio() {
		System.out.println("A data mais atual era: "+Data.getDataMaisRecente());
		datas[quantidadeDatas] = new Data();
		System.out.println("\nData gerada: " +datas[quantidadeDatas].toString()+"\n");
		quantidadeDatas++;
		menu();
	}
	
	public static int listarDatas() {
		System.out.println("\nDatas já criadas: \n"
				+ "Digite o código da data que deseja para realizar operaçoes: ");
		for(int i = 0; i < quantidadeDatas; i++) {
			System.out.println((i+1)+" - " + datas[i].toString());
			
		}
		
		return sc.nextInt()-1;
	}

	
	
	private static void operacoes() {
		int opcao = listarDatas();
		if(opcao > quantidadeDatas && opcao < 0) {
			System.out.println("Opcao inválida\n");
			listarDatas();
		}
		else {
			Data atual = datas[opcao];
			System.out.println("Escolha uma das opções para a data: "+atual.toString()
					+ "\n1 - Comparar data\n"
					+ "2 - Somar dias para gerar nova data "
					+ "\n3 - Voltar ao menu principal");
			switch(sc.nextInt()) {
				case 1:
					System.out.println("Digite a data a ser comparada (DD/MM/YYYY)");
					int data[] = converterData(sc.next().split("/"));
					System.out.println("A data mais recente entre essas duas opções é: "+atual.compararData(new Data(data[0],data[1],data[2])).toString()+ "\n");
					break;
				case 2:
					System.out.println("Digite a quantidade de dias a ser somado: ");
					System.out.println("A data gerada foi: "+atual.somarDias(sc.nextInt()) + "\n");
					break;
				case 3:
					break;
				default:
					System.out.println("Opção invalida\n");
					operacoes();
			}
			menu();
		}
	}


}
