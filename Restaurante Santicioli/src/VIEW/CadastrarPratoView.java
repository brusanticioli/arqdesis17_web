package VIEW;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import NEGOCIO.Cardapio;

public class CadastrarPratoView extends JFrame implements ActionListener
{
	// Atributos
	private JButton bVoltar, btnCadastrar;
	private JLabel label, lTitulo, lValor, lTipo, lDescricao, lDisponivel ,lQuantidade;
	private JTextField tTitulo, tValor , tQuantidade;
	private JComboBox comboBox;
	private JTextArea textArea;
	private String tipos[] = {"","Prato de Entrada", "Prato Principal","Bebida","Sobremesa"};
	private JCheckBox sim, nao;
	private ResourceBundle bn = null;

	public CadastrarPratoView()
	{
		super("Santicioli Restaurante");
		rc();

		// JLabel
		label       = new JLabel(bn.getString("cadastrariteml"));
		lTitulo     = new JLabel(bn.getString("nomeiteml"));
		lValor      = new JLabel(bn.getString("valorunitariol"));
		lTipo       = new JLabel(bn.getString("tipoiteml"));
		lDescricao  = new JLabel(bn.getString("descricaol"));
		lDisponivel = new JLabel(bn.getString("disponivell"));
		lQuantidade = new JLabel(bn.getString("quantidadeb"));

		// JTextField
		tTitulo   = new JTextField (30);
		tValor    = new JTextField ("0.00");
		tQuantidade = new JTextField(10);

		// ComboBox      
		comboBox = new JComboBox( tipos ); 
		comboBox.setMaximumRowCount( 3 );

		// TextArea
		textArea= new JTextArea(13, 35);

		// JCheckBox
		sim = new JCheckBox(bn.getString("simrb"));
		nao = new JCheckBox(bn.getString("naorb"));

		// Container Principal
		getContentPane().setLayout(null);

		// JButton
		bVoltar     = new JButton(bn.getString("voltarb"));
		btnCadastrar  = new JButton(bn.getString("cadastrarb"));

		// Ativar Bot�es
		bVoltar.addActionListener(this);
		btnCadastrar.addActionListener(this);

		// Formata o t�tulo
		label.setFont(new Font("Arial", Font.BOLD, 16));

		// Adicionando no Container
		getContentPane().add(label);
		getContentPane().add(bVoltar);
		getContentPane().add(btnCadastrar);
		getContentPane().add(lTitulo);
		getContentPane().add(lValor);
		getContentPane().add(lTipo);
		getContentPane().add(lDescricao);
//		getContentPane().add(lDisponivel);
		getContentPane().add(tTitulo);
		getContentPane().add(tValor);
		getContentPane().add(comboBox);
		getContentPane().add(textArea);
//		getContentPane().add(sim);
//		getContentPane().add(nao);
		textArea.setEditable(true);  
		getContentPane().add(lQuantidade);
		getContentPane().add(tQuantidade);
		
		// Posi��es 
		label.setBounds(200, 10, 500, 15); 
		bVoltar.setBounds(120, 320, 100, 25); 
		btnCadastrar.setBounds(250, 320, 120, 25); 
		lTitulo.setBounds(10, 50, 420, 25); 
		lValor.setBounds(10, 100, 420, 25);
		lTipo.setBounds(10, 150, 420, 25);
		lDescricao.setBounds(10, 200, 420, 25); 
//		lDisponivel.setBounds(10, 270, 420, 25); 
		lQuantidade.setBounds(10, 270, 420, 25);
		tTitulo.setBounds(120, 50, 350, 25); 
		tValor.setBounds(120, 100, 350, 25); 
		comboBox.setBounds(120, 150, 350, 25);
		textArea.setBounds(120, 200, 350, 60);
		tQuantidade.setBounds(120, 270, 50, 25);
//		sim.setBounds(120, 270, 50, 25);
//		nao.setBounds(170, 270, 50, 25);  

		// Configurando a tela
		setSize(500, 400); 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(500,200);
		setResizable(false);
	}

	// A��es dos Bot�es
	public void actionPerformed( ActionEvent event )
	{   
		if(event.getSource() == bVoltar){
			dispose();
		}

		//altera aqui para passar os dados da tela pro cad.inserir
		if(event.getSource() == btnCadastrar){
			try{
				Cardapio cad = new Cardapio();
				String titulo = tTitulo.getText();
				String descricao = textArea.getText();
				double valor = Double.parseDouble(tValor.getText());
				int quantidade = Integer.parseInt(tQuantidade.getText());
				int tipo = comboBox.getSelectedIndex();
				cad.inserir(tipo, titulo, descricao, valor , quantidade);
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
	public static void main(String args[]) 
	{ 
		CadastrarPratoView view = new CadastrarPratoView();
		view.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	} 

}