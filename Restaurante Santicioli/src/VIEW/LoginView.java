package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;

import javax.swing.*;

import NEGOCIO.Login;
import NEGOCIO.Criptografia;

import java.util.*;

public class LoginView extends JFrame implements ActionListener {

   // Atributos
   private JButton         btnLogin, btnCadastrar; 
   private JTextField      tLogin;
   private JPasswordField  pSenha;
   private JLabel          lLogin, lSenha;
   private static JComboBox       comboBox;  
   private static ResourceBundle bn = null;
   private String idiomas[] = {"Selecione o idioma","Português", "English", "Espanõl"};
   int senha;
   String login;
   
   // Mï¿ ½todo Construtor
   public LoginView() {
      super("Santicioli Restaurante");
      bn = ResourceBundle.getBundle("Ex1");
      
      // Container Principal
      getContentPane().setLayout(null);
      
      // JLabel
      lLogin          = new JLabel(bn.getString("loginl"));
      tLogin          = new JTextField (10);
      lSenha          = new JLabel(bn.getString("senhal"));
      
      // JPasswordField
      pSenha          = new JPasswordField (10);
      
      // JButton
      btnLogin        = new JButton(bn.getString("logarb"));
      btnCadastrar    = new JButton(bn.getString("cadastrarb"));
      getRootPane().setDefaultButton(btnLogin);
      
      // Adiciona aï¿½ï¿½o aos botï¿½es
      btnLogin.addActionListener(this);
      btnCadastrar.addActionListener(this);
      
      // JComboBox
      comboBox = new JComboBox( idiomas ); 
      comboBox.setMaximumRowCount( 3 );
        
      // Adicionando ao Container
      getContentPane().add(lLogin);
      getContentPane().add(tLogin);
      getContentPane().add(lSenha);
      getContentPane().add(pSenha);
      getContentPane().add(comboBox);
      getContentPane().add(btnLogin);
      getContentPane().add(btnCadastrar);
      
      // Posiï¿½ï¿½es 
      lLogin.setBounds(120, 20, 500, 15); 
      tLogin.setBounds(170, 20, 160, 25); 
      lSenha.setBounds(120, 60, 110, 25);  
      pSenha.setBounds(170, 60, 160, 25); 
      comboBox.setBounds(120, 100, 210, 25);
      btnLogin.setBounds(100, 160, 110, 25); 
      btnCadastrar.setBounds(220, 160, 110, 25);
   
      // Configurando a tela
      setSize(460, 250);  
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setLocation(500,200);
      setResizable(false);
      
      if(comboBox.getSelectedIndex() ==1)
      {
         bn = ResourceBundle.getBundle("Ex1", new Locale("pt", "BR"));
      }
      else if(comboBox.getSelectedIndex() ==2)
      {
         bn = ResourceBundle.getBundle("Ex1", Locale.US);
      }
      else if(comboBox.getSelectedIndex() ==3)
      {
         bn = ResourceBundle.getBundle("Ex1", new Locale("es","ES"));
      }
   }
   
   // Aï¿½ï¿½o dos botï¿½es
   @SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent event) 
   {
      if(event.getSource() == btnCadastrar){
         CadastroView casd = new CadastroView();
      }
      
      if(event.getSource() == btnLogin)
      {
         Criptografia crip = new Criptografia();
         UsuarioDAO usuariodao = new UsuarioDAO();
         senha = Integer.parseInt(pSenha.getText());
         login = tLogin.getText();
            		 
         try {
         	if(usuariodao.validarLogin(login,crip.cifrar(senha)))
         	{
         		WelcomeSupervisorView sup = new WelcomeSupervisorView();
         	}
            //crip.cifrar(senha);
         } 
         catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"senha invalida","erro",-1);
         	
         }
      }
   }   
   // ComboBox selecionado
   public static int rb()
   {
      int i = 0;
      if(comboBox.getSelectedIndex() ==0)
      {
         i++;
      }
      else if(comboBox.getSelectedIndex() ==1)
      {
         i = 1;
      }
      else if(comboBox.getSelectedIndex() ==2)
      {
         i = 2;
      }
      else if(comboBox.getSelectedIndex() ==3)
      {
         i = 3;
      }
      return i;
   }
   
   // Mï¿½todo MAIN
   public static void main(String args[]) 
   { 
      LoginView login = new LoginView();
   } 
}