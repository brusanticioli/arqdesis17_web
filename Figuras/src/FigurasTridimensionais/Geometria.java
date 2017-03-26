package FigurasTridimensionais;

import java.util.ArrayList;

import FigurasTridimensionais.Cilindro;
import FigurasTridimensionais.Cubo;
import FigurasTridimensionais.Esfera;
import FigurasTridimensionais.Figura;
import FigurasTridimensionais.Piramide;

public class Geometria {
	
	public static void main(String [] args){
		ArrayList<Figura> figura = new ArrayList<>();
		
		figura.add(new Esfera(5.0));
		figura.add(new Cilindro(5.0 , 3.0));
		figura.add(new Cubo(5.0 , 2.0, 3.0));
		figura.add(new Piramide(5.0 , 1.0, 3.0));
		
		// Mostrar o resultado
		for(Figura figuras:figura){
			System.out.println(figuras);
		}
	}
}
