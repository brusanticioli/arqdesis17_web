package VIEW;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Font;

public class EnviarNFView extends JFrame implements ActionListener{
	
   // Atributos
   JLabel lTitle, lDe, lAte;
   JTextField tNum, tDe, tAte;
   JButton bEnviar;
   private ResourceBundle bn = null;
	
   public EnviarNFView(){
      super("Santicioli Restaurante");
   	rc();
      
      // Container Principal
      getContentPane().setLayout(null);
   	
      // JLabel
      lTitle   = new JLabel(bn.getString("enviarnfrf"));
   	lDe      = new JLabel(bn.getString("del"));
      lAte     = new JLabel(bn.getString("atel"));
      
      // JTextField
      tNum  = new JTextField();
      tDe   = new JTextField("DD/MM/AAAA");
      tAte  = new JTextField("DD/MM/AAAA");
      
      // JButton
      bEnviar = new JButton(bn.getString("enviarb"));
      bEnviar.addActionListener(this);   
      
      // Formata o título
      lTitle.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando no Container
      getContentPane().add(lDe);
      getContentPane().add(tDe);
      getContentPane().add(lAte);
      getContentPane().add(tAte);
      getContentPane().add(tNum);
      getContentPane().add(bEnviar);
      getContentPane().add(lTitle);
       
      // Posições 
      lDe.setBounds(10, 70, 110, 25); 
      tDe.setBounds(50,70, 150, 25); 
      lAte.setBounds(10, 120, 110, 25); 
      tAte.setBounds(50, 120, 150, 25); 
      tNum.setBounds(300, 90, 90, 25);
      bEnviar.setBounds(390, 90, 70, 24);
      lTitle.setBounds(200, 20, 500, 15);
      
      // Configurando a tela
      setSize(500, 240);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);
      setResizable(false);
   }
	
   // Ação dos botões
   public void actionPerformed(ActionEvent event) {
   	if(event.getSource() == bEnviar){
         JOptionPane.showMessageDialog(null,"notas enviadas com sucesso","NF",-1);
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
      EnviarNFView c = new EnviarNFView();
   }
}

