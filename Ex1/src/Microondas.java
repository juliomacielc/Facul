public class Microondas {
	private static final int MAXPOTENCIA = 10;
	private static final int MINPOTENCIA = 1;

	private int temporizador;
	private int potencia;
	private boolean portaFechada;
	private boolean ligado;

	public Microondas() {
		this.temporizador = 0;
		this.potencia = (MAXPOTENCIA - MINPOTENCIA + 1) / 2; // Meio termo
		this.portaFechada = true;
		this.ligado = false;
	}

	public void ligar() {
		if (this.portaFechada && this.temporizador > 0) {
			this.ligado = true;
		}
	}

	public void interromperTemporizador() { // desligar
		this.temporizador = 0;
		this.ligado = false;
	}

	public void aumentarPotencia() {
		if (this.potencia < MAXPOTENCIA) {
			this.potencia++;
		}
	}

	public void diminuirPotencia() {
		if (this.potencia > MINPOTENCIA) {
			this.potencia--;
		}
	}

	public void abrirPorta() {
		if (!this.ligado) {
			this.portaFechada = false;
		}
	}

	public void fecharPorta() {
		this.portaFechada = true;
	}

	public void setTemporizador(int minutos, int segundos) {
		if (segundos > 0 && segundos < 60) {
			if (minutos >= 0 && minutos < 60) {
				this.temporizador = segundos + (minutos * 60);
			}
		}
	}

	public String temporizadorToString() {
		int minutos = this.temporizador / 60;
		int segundos = this.temporizador % 60;
		return (minutos < 10 ? "0" + minutos : minutos) + ":" + (segundos < 10 ? "0" + segundos : segundos);
	}
}
