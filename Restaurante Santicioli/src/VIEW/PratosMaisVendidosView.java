package VIEW;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class PratosMaisVendidosView extends JFrame implements ActionListener{
	
   // Atributos
   JLabel lTitle, lBuscar;
   JButton bQuant, bPreco, bVoltar;
   JTextField tProvisorio;
   ResourceBundle bn = null;
   
   public PratosMaisVendidosView(){
      super("Santicioli Restaurante");
      rc();
      
      // Container Principal   
      getContentPane().setLayout(null);
   	
      // JLabel
      lTitle   = new JLabel(bn.getString("maisvendidosl"));
      lBuscar  = new JLabel(bn.getString("buscarl"));
   	
      // JtextField
      tProvisorio = new JTextField( "" );
   	
      // JButton
      bQuant   = new JButton(bn.getString("quantidadeb"));
      bPreco   = new JButton(bn.getString("precob"));
      bVoltar  = new JButton(bn.getString("voltarb"));
      
      // Adiciona ação aos botões
      bQuant.addActionListener(this);
      bPreco.addActionListener(this);
      bVoltar.addActionListener(this);
      
      // Formata o título
      lTitle.setFont(new Font("Arial", Font.BOLD, 16));
   	
      // Adicionando no Container
      getContentPane().add(lBuscar);
      getContentPane().add(bQuant);
      getContentPane().add(bPreco);
      getContentPane().add(tProvisorio);
      getContentPane().add(bVoltar);
      getContentPane().add(lTitle);
       
      // Posições 
      lBuscar.setBounds(10, 70, 110, 25); 
      bQuant.setBounds(150, 70, 110, 25); 
      bPreco.setBounds(280, 70, 110, 25); 
      tProvisorio.setBounds(10, 120, 460, 150); 
      bVoltar.setBounds(200, 320, 110, 25);  
      lTitle.setBounds(180, 10, 500, 25);
      
      // Configurando a tela
      setSize(500, 400);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);
      setResizable(false);
   }

	// Ação dos botões
   public void actionPerformed(ActionEvent event) {
      if(event.getSource() == bVoltar){
         dispose();
      }
   }
   
   // Internacionalização
   public ResourceBundle rc()
   {
      if(LoginView.rb() ==1)
      {
         bn = ResourceBundle.getBundle("Ex1", new Locale("pt", "BR"));
      }
      else if(LoginView.rb() ==2)
      {
         bn = ResourceBundle.getBundle("Ex1", Locale.US);
      }
      else if(LoginView.rb() ==3)
      {
         bn = ResourceBundle.getBundle("Ex1", new Locale("es","ES"));
      }
      return bn;
   }
	
   // Método MAIN
   public static void main(String [] args){
      PratosMaisVendidosView c = new PratosMaisVendidosView();
   }

}
