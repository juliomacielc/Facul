package data;

public class Data {
	
	private static final int MESESCOM30DIAS[] = {4,6,9,11};  
	private static final Data DATAMINIMA = new Data(1, 1, 1900);
	private static Data dataMaisRecente = null;
	
	private int dia;
	private int mes;
	private int ano;
	
	private void init(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		if(!this.dataValida()) {
			this.dia = Data.DATAMINIMA.dia;
			this.mes = Data.DATAMINIMA.mes;
			this.ano = Data.DATAMINIMA.ano;
		}
		Data.dataMaisRecente = this.compararData(Data.dataMaisRecente);
	}
	
	public Data(int dia, int mes, int ano) {
		init(dia, mes, ano);
	}
	
	public Data() {
		Data aux = (Data.dataMaisRecente == null ? Data.DATAMINIMA: Data.dataMaisRecente.somarDias(1));
		init(aux.dia, aux.mes, aux.ano);
	}
	
		
	public Data somarDias(int diasSomar) {
		Data aux = this;
		if(diasSomar>0) {
			aux.dia +=diasSomar;
			aux.tratarSoma();
		}
		return aux;
	}
	
	private void tratarSoma() {
		if(!this.validarDia()) {
			this.dia =  this.dia - this.diasDoMes();
			this.mes++;
			if(!this.validarMes()) {
				this.ano++;
				this.mes = 1;
			}
			this.tratarSoma();
		}
	}
	
	public Data compararData(Data dataComparada) {
		if(dataComparada == null) {
			return this;
		} else if(this.compareTo(dataComparada)>0) {
			return this;
		}else
			return dataComparada;
	}
	
	public int compareTo(Data dataComparada) {
		int aux = this.ano - dataComparada.ano;
		if(aux == 0) {
			aux = this.mes - dataComparada.mes;
			if(aux == 0) {
				aux = this.dia - dataComparada.dia;
			}
		}
		return aux;
	}
	
	private boolean dataValida() {
		if(this.validarDia() && this.validarMes()) {
			if(Data.DATAMINIMA == null || this.compareTo(Data.DATAMINIMA) >=0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validarDia() {
		if(this.dia > 0) {
			if(this.dia <= this.diasDoMes()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validarMes() {
		if(this.mes> 0 && this.mes <= 12) {
			return true;
		} else {
			return false;
		}
	}
	
	public int diasDoMes() {
		for(int i = 0; i<Data.MESESCOM30DIAS.length; i++) {
			if(this.mes == Data.MESESCOM30DIAS[i]) {
				return 30;
			}
		}
		if(this.mes == 2) {
			if(this.anoBissexto()) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 31;
		}
	}
	
	public boolean anoBissexto() {
		if(this.ano%4 == 0) {
			if(this.ano % 100 != 0) {
				return true;
			}
		}else if(this.ano%400 == 0) {
			return true;
		}
		return false;
	}
	
	public void setDia(int dia) {
		int aux = this.dia;
		this.dia = dia;
		if(!this.validarDia()) {
			this.dia = aux;
		}
	}
	
	public void setMes(int mes) {
		int aux = this.mes;
		this.mes = mes;
		if(!this.validarMes()) {
			this.mes = aux;
		}
	}
	
	public void setAno(int ano) {
		int aux = this.ano;
		this.ano = ano;
		if(!this.dataValida()) {
			this.ano = aux;
		}
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public String toString() {
		return (this.dia<10 ? "0"+this.dia: this.dia) + "/" +(this.mes <10 ? "0"+this.mes:this.mes) + "/" + this.ano; 
	}
	static public String getDataMaisRecente() {
		Data aux = Data.dataMaisRecente;
		if(Data.dataMaisRecente == null) {
			aux = Data.DATAMINIMA;
		}
		return (aux.dia<10 ? "0"+aux.dia: aux.dia) + "/" +(aux.mes <10 ? "0"+aux.mes:aux.mes) + "/" + aux.ano; 
	}
	

}
