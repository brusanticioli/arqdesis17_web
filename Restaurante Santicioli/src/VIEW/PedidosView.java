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
import java.util.*;
import java.awt.Font;

public class PedidosView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bNovo , bConsultar , bAlterar, bExcluir;
   private JLabel label;
   private JTextArea textArea;
   private ResourceBundle bn = null;
   
   public PedidosView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label = new JLabel(bn.getString("pedidosl"));
      
      // JTextArea e ScrollPane
      textArea= new JTextArea(15, 35);
      JScrollPane scrollPane = new JScrollPane(textArea);
      setPreferredSize(new Dimension(450, 110));

      // Container Principal
      getContentPane().setLayout(null);
                           
      // JButton
      bNovo       = new JButton(bn.getString( "addpedidob"));
      bConsultar  = new JButton(bn.getString( "consultarb"));
      bAlterar    = new JButton(bn.getString( "alterarb"));
      bExcluir    = new JButton(bn.getString( "excluirb"));
            
      // Adicionar ação aos botões
      bNovo.addActionListener(this);
      bConsultar.addActionListener(this);
      bAlterar.addActionListener(this);
      bExcluir.addActionListener(this);
      
      // Formata o título
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando ao Container
      getContentPane().add(label);
      getContentPane().add(bNovo);
      getContentPane().add(bConsultar);
      getContentPane().add(bAlterar);
      getContentPane().add(bExcluir);
      getContentPane().add(textArea);
      textArea.setEditable(true);
       
      // Posições 
      label.setBounds(200, 10, 500, 15); 
      bNovo.setBounds(10, 320, 110, 25); 
      bConsultar.setBounds(130, 320, 110, 25); 
      bAlterar.setBounds(250, 320, 110, 25); 
      bExcluir.setBounds(370, 320, 110, 25);
      textArea.setBounds(10, 60, 460, 230);  
   
      // Configurando a tela
      setSize(500, 400);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);  
      setResizable(false);
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

   // Ação dos botões
   public void actionPerformed( ActionEvent event )
   { 
      if(event.getSource() == bNovo){
         NovoPedidoView npedi = new NovoPedidoView();
      }
      if(event.getSource() == bConsultar){
         ConsultaPedidoView cpedi = new ConsultaPedidoView();
      }
      if(event.getSource() == bAlterar){
         AlterarPedidoView apedi = new AlterarPedidoView();
      }
      if(event.getSource() == bExcluir){
         ExcluirPedidoView epedi = new ExcluirPedidoView();
      }
   }
   
   // Método MAIN
   public static void main(String args[]) 
   { 
      PedidosView view = new PedidosView();     
   } 

}
