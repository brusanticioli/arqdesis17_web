//prato
package VIEW;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.*;

public class ModalTemCertezaExcluirView2 extends JFrame implements ActionListener{
	
   JLabel lTitle;
   JButton bCancelar, bExcluir;
   JPanel painel1;
	ResourceBundle bn = null;
   
   public ModalTemCertezaExcluirView2(){
      super("Santicioli Restaurante");
   	rc();
      
      getContentPane().setLayout(null);
   	
      painel1 = new JPanel();
      painel1.setLayout(new GridLayout(1 , 2));
   	
      lTitle = new JLabel(bn.getString("confirmexil"));
   	
      bCancelar = new JButton(bn.getString("cancelarb"));
      bExcluir = new JButton(bn.getString("excluirb"));
      bExcluir.addActionListener(this);
      bCancelar.addActionListener(this);
       
      // Adicionando no Container
      getContentPane().add(bCancelar);
      getContentPane().add(bExcluir);
      getContentPane().add(lTitle);
       
      // Posições 
      bCancelar.setBounds(140, 70, 110, 30); 
      bExcluir.setBounds(270, 70, 110, 30);  
      lTitle.setBounds(120, 20, 500, 15);
      
      // Configurando a tela
      setSize(500, 150);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);

   }
	
   public void actionPerformed(ActionEvent event) {
   	if(event.getSource() == bCancelar){
         dispose();
      }
      if(event.getSource() == bExcluir){
         dispose();
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
      ModalTemCertezaExcluirView2 c = new ModalTemCertezaExcluirView2();
   }
}

