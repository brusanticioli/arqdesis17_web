package FigurasPlanas;

public abstract class Poligono extends Figura {
	// Atributos
	double base;
	double altura;
	
	// Construtores
	public Poligono (){}
	
	public Poligono (double base, double altura){
		this.base = base;
		this.altura = altura;
	}
	
	// M�todos de Acesso
	public double getBase() {
		return base;
	}
	
	public double getAltura() {
		return altura;
	}

	// M�todos Modificadores
	public void setBase(double base) {
		this.base = base;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	// M�todo para calcular a area do Pol�gono
	@Override
	public double area() {
		return 0;
	}
	
	// M�todo para calcular o perimetro do Pol�gono
	@Override
	public double perimetro() {
		return 0;
	}
	
	// M�todo toString
	@Override
	public String toString() {
		return "Poligono [base()=" + getBase() + ", altura()=" + getAltura() + "]";
	}
}
