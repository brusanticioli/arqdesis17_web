package FigurasTridimensionais;

import FigurasTridimensionais.Figura;

public class Cilindro extends Figura{
	// Atributos
	double raio;
	double altura;
	
	// Construtores
	public Cilindro(){}
	
	public Cilindro(double raio, double altura){
		this.raio = raio;
		this.altura = altura;
	}
	
	// M�todos de Acesso
	public double getRaio() {
		return raio;
	}
	
	public double getAltura() {
		return altura;
	}

	// M�todos Modificadores
	public void setRaio(double raio) {
		this.raio = raio;
	}	

	public void setAltura(double altura) {
		this.altura = altura;
	}

	// M�todo para calcular o volume do Cilindro
	@Override
	public double volume() {
		double pi = 3.1415;
		return pi * (Math.pow(getRaio(),2) * getRaio()) * getAltura();
	}
	
	// M�todo toString
	@Override
	public String toString(){
		return "Cilindro [volume()=" + volume() + "]";
	}
}
