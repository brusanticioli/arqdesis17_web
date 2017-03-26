package FigurasPlanas;

public class Circulo extends Figura {
	// Atributos
	double raio;
	
	// Construtores
	public Circulo(){}
	
	public Circulo(double raio){
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

	// M�todo que calcula a �rea do Circulo
	@Override
	public double area() {
		double pi = 3.1415;
		return Math.pow(getRaio(),2) * pi;
	}
	
	// M�todo que calcula o perimetro do Circulo
	@Override
	public double perimetro() {
		double pi = 3.1415;
		return 2 * pi * getRaio();
	}
	
	// M�todo toString
	@Override
	public String toString() {
		return "Circulo [area()=" + area() + ", perimetro()="+ perimetro() +"]";
	}
}
