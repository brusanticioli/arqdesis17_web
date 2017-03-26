package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class AlterarPedidoView extends JFrame implements ActionListener{
	
   // Atributos
   JComboBox JComboBox;
   JLabel lTitle, lNumeroM, lQuant;
   JTextField tMesa, tProvisorio1 , tProvisorio2;
   JButton bVoltar, bAlterar;
   String conteudoCombo[] = { "","Produto1", "Produto2", "Produto3", "Produto4"};
   ResourceBundle bn = null;
	
   public AlterarPedidoView(){
      super("Santicioli Restaurante");
      rc();
      
      // Container Principal
      getContentPane().setLayout(null);
   	
      // JLabel
      lTitle   = new JLabel(bn.getString("alterarpedidol"));
      lNumeroM = new JLabel(bn.getString("ndamesal"));
      lQuant   = new JLabel(bn.getString("quantidadel"));
   	
      // JTextField
      tMesa        = new JTextField(3);
      tProvisorio1 = new JTextField();
      tProvisorio2 = new JTextField();
   	
      // JComboBox
      JComboBox = new JComboBox( conteudoCombo ); 
      JComboBox.setMaximumRowCount( 5 );
   	
      // JButton
      bVoltar  = new JButton(bn.getString("voltarb"));
      bAlterar = new JButton(bn.getString("alterarb"));
      
      // Adiciona ação aos botões
      bVoltar.addActionListener(this);
      bAlterar.addActionListener(this);
      
      // Formata o título
      lTitle.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando no Container
      getContentPane().add(lNumeroM);
      getContentPane().add(tMesa);
      getContentPane().add(lQuant);
      getContentPane().add(tProvisorio1);
      getContentPane().add(JComboBox);
      getContentPane().add(tProvisorio2);
      getContentPane().add(bVoltar);
      getContentPane().add(bAlterar);
      getContentPane().add(lTitle);
       
      // Posições 
      lNumeroM.setBounds(10, 50, 110, 25); 
      tMesa.setBounds(100,50, 130, 25); 
      lQuant.setBounds(10, 100, 110, 25); 
      tProvisorio1.setBounds(100,100, 130, 25); 
      JComboBox.setBounds(10, 150, 460, 25);
      tProvisorio2.setBounds(10, 180, 460, 120);
      bVoltar.setBounds(120, 320, 110, 25); 
      bAlterar.setBounds(260, 320, 110, 25); 
      lTitle.setBounds(200, 10, 500, 15);  
   
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
   public void actionPerformed(ActionEvent event) {
      if(event.getSource() == bVoltar){
         dispose();
      }
      if(event.getSource() == bAlterar){
         dispose();
      }
   	
   }
	
   // Método MAIN
   public static void main(String [] args){
      AlterarPedidoView c = new AlterarPedidoView();
   }
}
