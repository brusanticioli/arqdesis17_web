package FigurasPlanas;

public class Retangulo extends Poligono implements Diagonal{
	// Construtores
	public Retangulo(){
		super (0.0 , 0.0);
	}
	
	public Retangulo(double base, double altura){
		super (base , altura);
	}
	
	// M�todo para calcular a �rea do Retangulo
	@Override
	public double area(){
		double area = getBase() * getAltura();
		return area;
	}
	
	// M�todo para calcular o perimetro do Retangulo
	@Override
	public double perimetro(){
		double perimetro = getBase() + getAltura() + getBase() + getAltura();
		return perimetro;
	}
	
	// M�todo para calcular a diagonal do Retangulo
	@Override
	public double diagonal() {
		return  Math.sqrt(Math.pow(getBase(), 2) + Math.pow(getAltura(), 2));
	}
	
	// M�todo toString
	@Override
	public String toString() {
		return "Retangulo [area()=" + area() + ", perimetro()="+ perimetro() +  ", diagonal()=" + diagonal() + ", toString()=" + super.toString() + "]";
	}
}
