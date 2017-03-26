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
	
	// Métodos de Acesso
	public double getBase() {
		return base;
	}
	
	public double getAltura() {
		return altura;
	}

	// Métodos Modificadores
	public void setBase(double base) {
		this.base = base;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	// Método para calcular a area do Polígono
	@Override
	public double area() {
		return 0;
	}
	
	// Método para calcular o perimetro do Polígono
	@Override
	public double perimetro() {
		return 0;
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Poligono [base()=" + getBase() + ", altura()=" + getAltura() + "]";
	}
}
