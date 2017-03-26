package FigurasTridimensionais;

import FigurasTridimensionais.Figura;

public abstract class Poliedro extends Figura{
	// Atributos
	double altura;
	double largura;
	double comprimento;
	
	// Construtor
	public Poliedro (){}
	
	public Poliedro (double largura, double altura, double comprimento){
		this.largura = largura;
		this.altura = altura;
		this.comprimento = comprimento;
	}
	
	// M�todos de Acesso
	public double getAltura() {
		return altura;
	}
	
	public double getLargura() {
		return largura;
	}

	public double getComprimento() {
		return comprimento;
	}
	
	// M�todos Modificadores
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	// M�todo que calcula o volume do Poliedro
	@Override
	public double volume(){
		return 0.0;
	}
	
	// M�todo toString
	@Override
	public String toString(){
		return "Poliedro [largura()=" + getLargura() + ", altura()=" + getAltura() + ", comprimento()=" + getComprimento() +"]";
	}
}
