package FigurasPlanas;

public class Circulo extends Figura {
	// Atributos
	double raio;
	
	// Construtores
	public Circulo(){}
	
	public Circulo(double raio){
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

	// Método que calcula a área do Circulo
	@Override
	public double area() {
		double pi = 3.1415;
		return Math.pow(getRaio(),2) * pi;
	}
	
	// Método que calcula o perimetro do Circulo
	@Override
	public double perimetro() {
		double pi = 3.1415;
		return 2 * pi * getRaio();
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Circulo [area()=" + area() + ", perimetro()="+ perimetro() +"]";
	}
}
