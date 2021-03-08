import java.util.Scanner;
public class App {
	static Microondas microondas = new Microondas();
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		menu();
	}

	public static void menu(){
		System.out.println("\n" + microondas.getStatus());

		System.out.println("Selecione a opção desejada\n"
		+"1 - Setar temporizador\n"
		+"2 - Aumentar Potência\n"
		+"3 - Diminuir Potência\n"
		+"4 - Abrir porta\n"
		+"5 - Fechar porta\n"
		+"6 - Ligar microondas\n"
		+"7 - Interromper/desligar");
		switch(sc.nextInt()){
			case 1:
				setarTemporizador();
				break;
			case 2:
				microondas.aumentarPotencia();
				break;
			case 3:
				microondas.diminuirPotencia();
				break; 
			case 4:
				microondas.abrirPorta();
				break;
			case 5:
				microondas.fecharPorta();
				break;
			case 6:
				microondas.ligar();
				break;
			case 7:
				microondas.interromperTemporizador();
				break;
			default:
				System.out.println("Opção inválida:");
		}
		menu();
	}

	public static void diminuirPotencia(){
		microondas.diminuirPotencia();
		menu();
	}

	public static void aumentarPotencia(){
		microondas.aumentarPotencia();
		menu();
	}
	
	public static void setarTemporizador(){
		System.out.println("\nDigite o tempo que deseja no formato MM:SS: ");
		String tempo[] = sc.next().split(":");
		int minutos = Integer.parseInt(tempo[0]);
		int segundos = Integer.parseInt(tempo[1]);
		microondas.setTemporizador(minutos, segundos);
	}
}
