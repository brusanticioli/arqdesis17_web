package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class HoraDePicoView extends JFrame implements ActionListener{
	
   // Atributos
   JLabel lTitle, lPeriodo, lData, lAte;
   JTextField tPeriodo, tAte, tData ,tProvisorio;
   JButton bOk, bVoltar;
   ResourceBundle bn = null;
   
   public HoraDePicoView(){
      super("Santicioli Restraurante");
      rc();
   	
      // Container Principal
      getContentPane().setLayout(null);
   	
      // JLabel
      lTitle   = new JLabel(bn.getString("horariopicol"));
      lPeriodo = new JLabel(bn.getString("periodol"));
      lData    = new JLabel(bn.getString("datal"));
      lAte     = new JLabel(bn.getString("atel"));
   	
      // JTextField
      tPeriodo    = new JTextField( "00:00" );
      tData       = new JTextField( "DD/MM/AAAA" );
      tAte        = new JTextField( "00:00" );
      tProvisorio = new JTextField("");
   	
      // JButton
      bOk      = new JButton(bn.getString("okb"));
      bVoltar  = new JButton(bn.getString("voltarb"));
      
      // Adiciona ação aos botões
      bOk.addActionListener(this);
      bVoltar.addActionListener(this);
      
      // Formata o título
      lTitle.setFont(new Font("Arial", Font.BOLD, 16));
   
   	// Adicionando ao Container
      getContentPane().add(lTitle);
      getContentPane().add(lPeriodo);
      getContentPane().add(tPeriodo);
      getContentPane().add(lAte);
      getContentPane().add(tAte);
      getContentPane().add(lData);
      getContentPane().add(tData);
      getContentPane().add(bOk);
      getContentPane().add(bVoltar);
      getContentPane().add(tProvisorio);
      
      // Posições 
      lTitle.setBounds(200, 10, 500, 15); 
      lPeriodo.setBounds(10, 60, 110, 25); 
      tPeriodo.setBounds(80, 60, 110, 25);  
      lAte.setBounds(200, 60, 110, 25); 
      tAte.setBounds(240, 60, 110, 25);
      lData.setBounds(10, 120, 110, 25); 
      tData.setBounds(80, 120, 110, 25); 
      bOk.setBounds(200, 120, 60, 25);
      bVoltar.setBounds(200, 330, 110, 25);
      tProvisorio.setBounds(10, 160, 470, 150); 
      
   
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
      if(event.getSource() == bOk){
         
      }
   	
   }
   
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
	
   public static void main(String [] args){
      HoraDePicoView c = new HoraDePicoView();
   }
}
