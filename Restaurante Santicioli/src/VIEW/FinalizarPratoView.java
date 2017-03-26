package VIEW;

import java.awt.Container;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.*;
import java.awt.Font;

public class FinalizarPratoView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bFinalizar;
   private JLabel label, lMesa, lPrato;
   private JTextField tMesa;
   private JComboBox       comboBox; 
   private String pratos[] = {"Selecine uma opção"};
   private ResourceBundle bn = null;
   
   public FinalizarPratoView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label    = new JLabel(bn.getString("finalizariteml"));
      lMesa    = new JLabel(bn.getString("ndamesal"));
      lPrato   = new JLabel(bn.getString("finalizariteml"));
      
      // JTextField
      tMesa    = new JTextField (10);
      
      // JComboBox
      comboBox = new JComboBox( pratos ); 
      comboBox.setMaximumRowCount( 3 );
      
      // Container Principal
      getContentPane().setLayout(null);
                          
      // JButton
      bFinalizar = new JButton(bn.getString( "finalizarb"));
      
      // Ativar Botões
      bFinalizar.addActionListener(this);
      
      // Formata o título
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando ao Container
      getContentPane().add(label);
      getContentPane().add(lMesa);
      getContentPane().add(lPrato);
      getContentPane().add(tMesa);
      getContentPane().add(comboBox);
      getContentPane().add(bFinalizar);
      
      // Posições 
      label.setBounds(180, 10, 500, 15); 
      lMesa.setBounds(10, 80, 110, 25); 
      lPrato.setBounds(10, 130, 110, 25); 
      tMesa.setBounds(60, 80, 110, 25); 
      comboBox.setBounds(60, 130, 400, 25); 
      bFinalizar.setBounds(350, 80, 110, 25); 
   
      // Configurando a tela
      setSize(500, 250);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200); 
      setResizable(false);
   }

   // Ações dos Botões
   public void actionPerformed( ActionEvent evento )
   {
      // ação
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
   public static void main(String args[]) 
   { 
      FinalizarPratoView finalizar = new FinalizarPratoView();
   } 

}
