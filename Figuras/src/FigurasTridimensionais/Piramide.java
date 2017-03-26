package FigurasTridimensionais;

import FigurasTridimensionais.Poliedro;

public class Piramide extends Poliedro {
	// Construtores
	public Piramide(){
		super(0.0, 0.0, 0.0);
	}
	
	public Piramide(double largura, double altura, double comprimento){
		super(largura, altura, comprimento);
	}
	
	// Método para calcular o volume da Pirâmide
	public double volume(){
		double volume = (1 * getLargura() * getAltura() * getComprimento()) / 3;
		return volume;
	}
	
	// Método toString
	@Override
	public String toString(){
		return "Piramide [volume()=" + volume() + ", toString()=" + super.toString() +"]";
	}
}

