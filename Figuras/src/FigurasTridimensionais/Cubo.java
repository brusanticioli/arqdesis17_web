package FigurasTridimensionais;

import FigurasTridimensionais.Poliedro;

public class Cubo extends Poliedro {
	// Construtores
	public Cubo(){
		super(0.0, 0.0, 0.0);
	}
	
	public Cubo(double largura, double altura, double comprimento){
		super(largura, altura, comprimento);
	}
	
	// Método para calcular o volume do Cubo
	public double volume(){
		double volume = getLargura() * getAltura() * getComprimento();
		return volume;
	}
	
	// Método toString
	@Override
	public String toString(){
		return "Cubo [volume()=" + volume() + ", toString()=" + super.toString() +"]";
	}
}
