package VIEW;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;
import java.awt.Font;

public class WelcomeGarcomView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bPedidos , bConsultarPratos;
   private JLabel label;
   private ResourceBundle bn = null;
   
   public WelcomeGarcomView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label = new JLabel(bn.getString("bemvindol"));
      
      // Container Principal
      getContentPane().setLayout(null);

      // JButton
      bPedidos          = new JButton(bn.getString( "pedidosb"));
      bConsultarPratos  = new JButton(bn.getString( "consultaritemb"));
   
      // Adiciona a��o aos bot�es
      bPedidos.addActionListener(this);
      bConsultarPratos.addActionListener(this);
      
      // Formata o t�tulo
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionar ao Container
      getContentPane().add(label);
      getContentPane().add(bPedidos);
      getContentPane().add(bConsultarPratos);
       
      // Posi��es 
      label.setBounds(150, 10, 500, 15); 
      bPedidos.setBounds(40, 80, 150, 35);  
      bConsultarPratos.setBounds(200, 80, 150, 35);
   
      // Configurando a tela
      setSize(400, 200);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);
      setResizable(false);
   }

   // A��o dos bot�es
   public void actionPerformed( ActionEvent evento )
   {
      // A��es dos Bot�es
   }
   
   // Internacionaliza��o
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
   
   // M�todo MAIN
   public static void main(String args[]) 
   { 
      WelcomeGarcomView garcom = new WelcomeGarcomView();
   } 

}
