package NEGOCIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArquivoTXT {
	 
	  public ArquivoTXT(String sen) throws IOException {
		  Scanner ler = new Scanner(System.in);
		  
		 
		    FileWriter arq = new FileWriter("usuario.txt", true);
		    PrintWriter gravarArq = new PrintWriter(arq); 
		
		    gravarArq.println(sen);
		 
		    arq.close();
		 
		  }
}


