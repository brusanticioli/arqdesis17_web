package VIEW;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;
import java.awt.Font;

public class WelcomeSupervisorView extends JFrame implements ActionListener
{
   // Atributos
   private JButton bCardapio , bPedidos , bEnviarNf , bPriorizar , bImprimirConta , bMaisVendidos , bHorarioPico , bFecharConta;
   private JLabel label;
   private ResourceBundle bn = null;
   
   public WelcomeSupervisorView()
   {
      super("Santicioli Restaurante");
      rc();
      
      // JLabel
      label = new JLabel(bn.getString("bemvindol"));
      
      // Container Principal
      getContentPane().setLayout(null);
                            
      // JButton
      bCardapio      = new JButton(bn.getString( "cardapiob"));
      bPedidos       = new JButton(bn.getString( "pedidosb"));
      bEnviarNf      = new JButton(bn.getString( "emitirnfb"));
      bPriorizar     = new JButton(bn.getString( "priorizarb"));
      bImprimirConta = new JButton(bn.getString( "imprimircontab"));
      bMaisVendidos  = new JButton(bn.getString( "maisvendidosb"));
      bHorarioPico   = new JButton(bn.getString( "horariopicob" ));
      bFecharConta   = new JButton(bn.getString( "fecharcontab" ));
   
      // Adiciona ação aos botões
      bCardapio.addActionListener(this);
      bPedidos.addActionListener(this);
      bEnviarNf.addActionListener(this);
      bPriorizar.addActionListener(this);
      bImprimirConta.addActionListener(this);
      bMaisVendidos.addActionListener(this);
      bHorarioPico.addActionListener(this);
      bFecharConta.addActionListener(this);
      
      // Formata o título
      label.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando ao Container
      getContentPane().add(label);
      getContentPane().add(bCardapio);
      getContentPane().add(bPedidos);
      getContentPane().add(bEnviarNf);
      getContentPane().add(bPriorizar);
      getContentPane().add(bImprimirConta);
      getContentPane().add(bMaisVendidos);
      getContentPane().add(bHorarioPico);
      getContentPane().add(bFecharConta);
      
      // Posições 
      label.setBounds(150, 10, 500, 15); 
      bCardapio.setBounds(40, 80, 150, 35); 
      bImprimirConta.setBounds(200, 80, 150, 35); 
      bPedidos.setBounds(40, 150, 150, 35); 
      bMaisVendidos.setBounds(200, 150, 150, 35);
      bEnviarNf.setBounds(40, 220, 150, 35); 
      bHorarioPico.setBounds(200, 220, 150, 35);
      bPriorizar.setBounds(40, 290, 150, 35); 
      bFecharConta.setBounds(200, 290, 150, 35);
   
      // Configurando a tela
      setSize(400, 400);  
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
      if(event.getSource() == bCardapio){
         CardapioView car = new CardapioView();
      }
      if(event.getSource() == bPedidos){
         PedidosView ppp = new PedidosView();
      }
      if(event.getSource() == bEnviarNf){
         EnviarNFView ennf = new EnviarNFView();
      }
      if(event.getSource() == bPriorizar){
         PriorizarPedidoView pp = new PriorizarPedidoView();
      }
      if(event.getSource() == bImprimirConta){
         ImprimirContaView imcon = new ImprimirContaView();
      }
      if(event.getSource() == bMaisVendidos){
         PratosMaisVendidosView mvend = new PratosMaisVendidosView();
      }
      if(event.getSource() == bHorarioPico){
         HoraDePicoView hp = new HoraDePicoView();
      }
      if(event.getSource() == bFecharConta){
         FechamentoContaView fc = new FechamentoContaView();
      }
   }
   
   // Método MAIN
   public static void main(String args[]) 
   { 
      WelcomeSupervisorView supervisor = new WelcomeSupervisorView();      
   } 
}
