package VIEW;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import NEGOCIO.Cardapio;

import java.awt.Font;

public class ExcluirPratoView extends JFrame implements ActionListener{

	// Atributos
	JLabel lTitle;
	JButton bVoltar, bExcluir, bOk;
	JTextField tProvisorio, tPedido;
	ResourceBundle bn = null;

	public ExcluirPratoView(){
		super("Santicioli Restaurante");
		rc();

		// Container Principal
		getContentPane().setLayout(null);

		// JLabel
		lTitle = new JLabel(bn.getString("excluiriteml"));

		// JTextField
		tPedido     = new JTextField(bn.getString( "excluiritemt" ));
		tProvisorio = new JTextField( "" );

		// JButton
		bVoltar  = new JButton(bn.getString("voltarb"));
		bExcluir = new JButton(bn.getString("excluirb"));
		bOk      = new JButton(bn.getString("okb"));

		// Adiciona a��o aos bot�es
		bVoltar.addActionListener(this);
		bExcluir.addActionListener(this);
		bOk.addActionListener(this);

		// Formata o t�tulo
		lTitle.setFont(new Font("Arial", Font.BOLD, 16));

		// Adicionando no Container
		getContentPane().add(tPedido);
		getContentPane().add(bOk);
		getContentPane().add(bVoltar);
		getContentPane().add(bExcluir);
		getContentPane().add(lTitle);
		getContentPane().add(tProvisorio);

		// Posi��es 
		tPedido.setBounds(10, 50, 400, 25); 
		bVoltar.setBounds(150, 320, 100, 25); 
		bExcluir.setBounds(270, 320, 100, 25);
		tProvisorio.setBounds(10, 90, 460, 200); 
		lTitle.setBounds(200, 10, 500, 15);

		// Configurando a tela
		setSize(500, 400);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(500,200);
		setResizable(false);
	}

	// A��o dos bot�es
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == bVoltar){
			dispose();
		}

		//altera aqui para passar os dados da tela pro cad.ecluir
		if(event.getSource() == bExcluir){
			//ModalTemCertezaExcluirView2 mv = new ModalTemCertezaExcluirView2();
			try{
				int id = Integer.parseInt(tPedido.getText());
				Cardapio cad = new Cardapio();
				cad.excluir(id);
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}

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
	public static void main(String [] args){
		ExcluirPratoView c = new ExcluirPratoView();
	}
}
