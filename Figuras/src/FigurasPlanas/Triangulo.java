package FigurasPlanas;

public class Triangulo extends Poligono {
	// Construtores
	public Triangulo(){
		super (0.0 , 0.0);
	}
	
	public Triangulo(double base, double altura){
		super (base , altura);
	}
	
	// M�todo para calcular a area do Triangulo
	@Override
	public double area(){
		double area = (getBase() * getAltura()) / 2 ;
		return area;
	}
	
	// M�todo para calcular o perimetro do Triangulo
	@Override
	public double perimetro(){
		double perimetro = 0.0;
		return perimetro;
	}
	
	// M�todo toString
	@Override
	public String toString() {
		return "Triangulo [area()=" + area() + ", perimetro()="+ perimetro() + ", toString()=" + super.toString() + "]";
	}
}
