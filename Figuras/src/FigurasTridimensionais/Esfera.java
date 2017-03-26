package FigurasTridimensionais;

import FigurasTridimensionais.Figura;

public class Esfera extends Figura{
	// Atributos
	double raio;
	
	// Construtores
	public Esfera(){}
	
	public Esfera(double raio){
		this.raio = raio;
	}
	
	// M�todo de Acesso
	public double getRaio() {
		return raio;
	}

	// M�todo Modificador
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	// M�todo para calcular o volume da Esfera
	@Override
	public double volume() {
		double pi = 3.1415;
		return (4 * pi * (getRaio() * getRaio() * getRaio())) / 3;
	}
	
	// M�todo toString
	@Override
	public String toString(){
		return "Esfera [volume()=" + volume() + "]";
	}
}
