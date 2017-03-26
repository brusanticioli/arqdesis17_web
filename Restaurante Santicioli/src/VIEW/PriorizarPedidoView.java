package VIEW;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.*;
import java.awt.Font;

public class PriorizarPedidoView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bVoltar ,bPriorizar, bDireita, bEsquerda;
   private JLabel label, lPedidos, lPriorizados;
   private JTextArea tPedidos, tPriorizados;
   private ResourceBundle bn = null;
   
   public PriorizarPedidoView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label       = new JLabel(bn.getString("priorizarpedidol"));
      lPedidos    = new JLabel(bn.getString("pedidosl"));
      lPriorizados= new JLabel(bn.getString("priorizadosl"));
      
      // TextArea
      tPedidos       = new JTextArea(13, 35);
      tPriorizados   = new JTextArea(13, 35);
      
      // Container Principal
      getContentPane().setLayout(null);
      
      // JButton 
      bVoltar     = new JButton(bn.getString( "voltarb"));
      bPriorizar  = new JButton(bn.getString( "priorizarb"));      
      bEsquerda   = new JButton( "<");
      bDireita    = new JButton( ">");
            
      // Adicionar ação aos botões
      bVoltar.addActionListener(this);
      bPriorizar.addActionListener(this);
      bEsquerda.addActionListener(this);
      bDireita.addActionListener(this);
      
      // Formata o título
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando ao Container
      getContentPane().add(label);
      getContentPane().add(bVoltar);
      getContentPane().add(bPriorizar);
      getContentPane().add(lPedidos);
      getContentPane().add(tPedidos);
      getContentPane().add(lPriorizados);
      getContentPane().add(tPriorizados);
      getContentPane().add(bEsquerda);
      getContentPane().add(bDireita);
       
      // Posições 
      label.setBounds(200, 10, 500, 15); 
      bVoltar.setBounds(130, 320, 110, 25); 
      bPriorizar.setBounds(270, 320, 110, 25); 
      lPedidos.setBounds(10, 60, 110, 25); 
      tPedidos.setBounds(10, 90, 180, 210);
      lPriorizados.setBounds(280, 60, 110, 25); 
      tPriorizados.setBounds(290, 90, 180, 210);
      bEsquerda.setBounds(220, 190, 50, 25); 
      bDireita.setBounds(220, 150, 50, 25);  
   
      // Configurando a tela
      setSize(500, 400);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);
      setResizable(false);
   }

   // Ação dos botões
   public void actionPerformed( ActionEvent event )
   {
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
   public static void main(String args[]) 
   { 
      PriorizarPedidoView view = new PriorizarPedidoView();      
   } 

}
