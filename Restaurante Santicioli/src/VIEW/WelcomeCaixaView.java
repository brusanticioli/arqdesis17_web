package VIEW;

import java.awt.Container;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;
import java.awt.Font;

public class WelcomeCaixaView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bPedidos , bFecharConta , bImprimirConta, bEnviarNf;
   private JLabel label;
   private ResourceBundle bn = null;
   
   public WelcomeCaixaView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label = new JLabel(bn.getString("bemvindol"));
      
      // Container Principal
      getContentPane().setLayout(null);
                            
      // JButton 
      bPedidos       = new JButton(bn.getString( "pedidosb"));
      bFecharConta   = new JButton(bn.getString( "fecharcontab" ));
      bImprimirConta = new JButton(bn.getString( "imprimircontab"));
      bEnviarNf      = new JButton(bn.getString( "emitirnfb"));
      
      // Ativar Bot�es
      bPedidos.addActionListener(this);
      bFecharConta.addActionListener(this);
      bImprimirConta.addActionListener(this);
      bEnviarNf.addActionListener(this);
      
      // Formata o t�tulo
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando ao Container
      getContentPane().add(label);
      getContentPane().add(bPedidos);
      getContentPane().add(bFecharConta);
      getContentPane().add(bImprimirConta);
      getContentPane().add(bEnviarNf);
       
      // Posi��es 
      label.setBounds(150, 10, 500, 15); 
      bPedidos.setBounds(40, 80, 150, 35); 
      bFecharConta.setBounds(200, 80, 150, 35); 
      bImprimirConta.setBounds(40, 150, 150, 35); 
      bEnviarNf.setBounds(200, 150, 150, 35);
   
      // Configurando a tela
      setSize(400, 280);  
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
      WelcomeCaixaView caixa = new WelcomeCaixaView();
   } 

}
