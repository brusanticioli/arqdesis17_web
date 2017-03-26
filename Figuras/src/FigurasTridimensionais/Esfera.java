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
	
	// Método de Acesso
	public double getRaio() {
		return raio;
	}

	// Método Modificador
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	// Método para calcular o volume da Esfera
	@Override
	public double volume() {
		double pi = 3.1415;
		return (4 * pi * (getRaio() * getRaio() * getRaio())) / 3;
	}
	
	// Método toString
	@Override
	public String toString(){
		return "Esfera [volume()=" + volume() + "]";
	}
}
