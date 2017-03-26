package FigurasPlanas;

public class Quadrado extends Poligono implements Diagonal{
	// Construtores
	public Quadrado(){
		super (0.0 , 0.0);
	}
	
	public Quadrado(double base, double altura){
		super (base , altura);
	}
	
	// Método para calcular a área do Quadrado
	@Override
	public double area(){
		double area = getBase() * getAltura();
		return area;
	}
	
	// Método para calcular o perimetro do Quadrado
	@Override
	public double perimetro(){
		double perimetro =  getBase() + getBase() + getBase() + getBase();
		return perimetro;
	}
	
	// Método para calcular a diagonal do Quadrado
	@Override
	public double diagonal() {
		return Math.sqrt(area()) * Math.sqrt(2);
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Quadrado [area()=" + area() + ", perimetro()="+ perimetro() + ", diagonal()=" + diagonal() + ", toString()=" + super.toString() + "]";
	}
}
