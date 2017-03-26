package FigurasPlanas;

import java.util.ArrayList;

public class Geometria {
	public static void main(String[] args) {
		ArrayList<Figura> figura = new ArrayList<>();
		
		figura.add(new Circulo(5.0));
		figura.add(new Triangulo(5.0 , 3.0));
		figura.add(new Losango(5.0 , 2.0));
		figura.add(new Retangulo(5.0 , 1.0));
		figura.add(new Quadrado(5.0 , 4.0));
		
		// Mostrar os resultados
		for(Figura figuras:figura){
			System.out.println(figuras);
		}

	}
}
