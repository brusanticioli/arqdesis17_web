package VIEW;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.*;
import java.awt.Font;

public class ImprimirContaView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bVoltar ,bAlterar, bImprimir, bOk;
   private JLabel label, lMesa;
   private JTextArea textArea;
   private JTextField tMesa;
   private ResourceBundle bn = null;
   
   public ImprimirContaView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label = new JLabel(bn.getString("imprimircontal"));
      lMesa = new JLabel(bn.getString("ndamesal"));
      
      // JTextField
      tMesa = new JTextField (10);
      
      // JTextArea e ScrollPane
      textArea= new JTextArea(13, 35);
      JScrollPane scrollPane = new JScrollPane(textArea);
      setPreferredSize(new Dimension(450, 110));

      // Container Principal
      getContentPane().setLayout(null);    
                         
      // JButton 
      bVoltar     = new JButton(bn.getString( "voltarb"));
      bAlterar    = new JButton(bn.getString( "alterarb"));
      bImprimir   = new JButton(bn.getString( "imprimirb"));
      bOk         = new JButton(bn.getString( "okb"));
            
      // Ativar Botões
      bVoltar.addActionListener(this);
      bAlterar.addActionListener(this);
      bImprimir.addActionListener(this);
      bOk.addActionListener(this);
      
      // Formata o título
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando ao Container
      getContentPane().add(label);
      getContentPane().add(bVoltar);
      getContentPane().add(bAlterar);
      getContentPane().add(bImprimir);
      getContentPane().add(lMesa);
      getContentPane().add(tMesa);
      getContentPane().add(bOk);
      getContentPane().add(textArea);
      textArea.setEditable(true);
      
      // Posições 
      label.setBounds(180, 20, 500, 15); 
      bVoltar.setBounds(80, 320, 110, 25); 
      bAlterar.setBounds(200, 320, 110, 25);  
      bImprimir.setBounds(320, 320, 110, 25); 
      lMesa.setBounds(10, 50, 110, 25);
      tMesa.setBounds(90, 50, 80, 25); 
      bOk.setBounds(175, 50, 60, 25); 
      textArea.setBounds(10, 80, 460, 180); 
   
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
      ImprimirContaView view = new ImprimirContaView();      
   } 

}
