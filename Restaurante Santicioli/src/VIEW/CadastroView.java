package VIEW;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import NEGOCIO.Cadastro;
import NEGOCIO.Criptografia;
import UTEIS.CustomTextField;

public class CadastroView extends JFrame implements ActionListener{
	
   private static final String PromptSupport = null;
// Atributos
   JComboBox JComboBox;
   JLabel lNome , lCodigo , lEmail , lLogin , lSenha, lTitle , lComboTipo;  
   JTextField tNome, tCodigo, tEmail, tLogin, tTipo , tTeste;
   JButton bCancelar , bCadastrar;
   String conteudoCombo[] = { "Selecine um Tipo","Supervisor", "Garçom", "Cozinheiro", "Caixa"};
   private ResourceBundle bn = null;
   int senha;
   String login;
   JPasswordField tSenha;
   
   public CadastroView(){
      super("Santicioli Restaurante");
      rc();

      // Container Principal
      getContentPane().setLayout(null);
   	
      // JLabel
      lTitle      = new JLabel(bn.getString("cadastrarl"));
      lNome       = new JLabel(bn.getString("nomel"));
      lCodigo     = new JLabel("Codigo");
      lEmail      = new JLabel(bn.getString("emaill"));
      lLogin      = new JLabel(bn.getString("loginl"));
      lSenha      = new JLabel(bn.getString("senhal"));
      lComboTipo  = new JLabel(bn.getString("cargol"));
   	
      // JTextField
      tNome  = new JTextField(bn.getString("nomet"));
      tCodigo= new JTextField("Codigo");
      tEmail = new JTextField(bn.getString( "emailt" ));
      tLogin = new JTextField(bn.getString( "logint" ));
      tSenha = new JPasswordField(bn.getString( "senhat" ));
      
      
      // JComboBox
      JComboBox = new JComboBox( conteudoCombo ); 
      JComboBox.setMaximumRowCount( 5 );
   	
      // JButton
      bCancelar   = new JButton(bn.getString("cancelarb"));
      bCadastrar  = new JButton(bn.getString("cadastrarb"));
      
      // Adiciona aï¿½ï¿½o aos botï¿½ess
      bCancelar.addActionListener(this);
      bCadastrar.addActionListener(this);
      
      // Formata o tï¿½tulo
      lTitle.setFont(new Font("Arial", Font.BOLD, 16));
      
      // Adicionando no Container
      getContentPane().add(lNome);
      getContentPane().add(lCodigo);
      getContentPane().add(lEmail);
      getContentPane().add(lLogin);
      getContentPane().add(lSenha);
      getContentPane().add(lComboTipo);
      getContentPane().add(tNome);
      getContentPane().add(tCodigo);
      getContentPane().add(tEmail);
      getContentPane().add(tLogin);
      getContentPane().add(tSenha);
      getContentPane().add(JComboBox);
      getContentPane().add(bCadastrar);
      getContentPane().add(bCancelar);
      getContentPane().add(lTitle);
       
      // Posiï¿½ï¿½es
      lTitle.setBounds(170, 10, 200, 25); 
      lNome.setBounds(10, 50, 110, 25); 
      lCodigo.setBounds(10,90, 110, 25); 
      lEmail.setBounds(10, 140, 110, 25); 
      lLogin.setBounds(10, 190, 110, 25); 
      lSenha.setBounds(10, 240, 110, 25);
      lComboTipo.setBounds(10, 290, 110, 25);
      tNome.setBounds(80, 50, 370, 25); 
      tCodigo.setBounds(80, 90, 370, 25); 
      tEmail.setBounds(80, 140, 370, 25);
      tLogin.setBounds(80,190, 370, 25); 
      tSenha.setBounds(80, 240, 370, 25);
      JComboBox.setBounds(80, 290, 370, 25);
      bCancelar.setBounds(140, 330, 110, 25); 
      bCadastrar.setBounds(270, 330, 110, 25);   
   
      // Configurando a tela
      setSize(500, 400);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);
      setResizable(false);  	
   }

   // Aï¿½ï¿½o dos botï¿½es
   public void actionPerformed(ActionEvent event) {
      if(event.getSource() == bCadastrar)
      {
    	  int s = 0;
    	 try
    	 {
    		 s = Integer.parseInt(tSenha.getText());
    	 }
    	 catch(NumberFormatException e)
    	 {
    		 JOptionPane.showMessageDialog(null,"Somente números"); 
    		 return ;
    	 }
         String n = "" +  tNome.getText();
         int c = Integer.parseInt(tCodigo.getText());
         String e = "" + tEmail.getText();
         String l = "" + tLogin.getText();
         
         int jc2 = JComboBox.getSelectedIndex();
         String jc = "";
         if(JComboBox.getSelectedIndex() == 1)
         {
            jc = "Supervisor";
         }
         else if(JComboBox.getSelectedIndex() == 2)
         {
            jc = "Garçom";
         }
         else if(JComboBox.getSelectedIndex() == 3)
         {
            jc = "Cozinheiro";
         }
         else if(JComboBox.getSelectedIndex() == 4)
         {
            jc = "Caixa";
         }
         Cadastro cad = new Cadastro();
         cad.inserir(n, c, e, l, s, jc2);
         Criptografia crip = new Criptografia();
         UsuarioDAO usuariodao = new UsuarioDAO();
         senha = s;
         login = tLogin.getText();
            		 
         try {
         	usuariodao.cadastrarLogin(login,crip.cifrar(senha));
            crip.cifrar(senha);
         	
         } 
         catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"senha invalida","erro",-1);
         	
         }
         dispose();
      }
   	
      if(event.getSource() == bCancelar){
         dispose();
      }
   }
   
   // Internacionalizaï¿½ï¿½o
   public ResourceBundle rc()
   {
      if(LoginView.rb() == 1)
      {
         bn = ResourceBundle.getBundle("Ex1", new Locale("pt", "BR"));
      }
      else if(LoginView.rb() == 2)
      {
         bn = ResourceBundle.getBundle("Ex1", Locale.US);
      }
      else if(LoginView.rb() == 3)
      {
         bn = ResourceBundle.getBundle("Ex1", new Locale("es","ES"));
      }
      return bn;
   }
	
   // Mï¿½todo MAIN
   public static void main(String [] args){
      CadastroView c = new CadastroView();
   }
}
