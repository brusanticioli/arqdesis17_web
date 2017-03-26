package FigurasPlanas;

public class Losango extends Poligono {
	// Construtores
	public Losango(){
		super (0.0 , 0.0);
	}
	
	public Losango(double base, double altura){
		super (base , altura);
	}
	
	// Método para calcular a area do Losango
	@Override
	public double area(){
		double area = getBase() * getAltura();
		return area;
	}
	
	// Método para calcular o perimetro do Losango
	@Override
	public double perimetro(){
		double perimetro = getBase() + getBase() + getBase() + getBase();
		return perimetro;
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Losango [area()=" + area() + ", perimetro()="+ perimetro() + ", toString()=" + super.toString() + "]";
	}
}
