package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import NEGOCIO.Cardapio;

import javax.swing.JCheckBox;
import java.util.*;
import java.awt.Font;

public class AlterarPratoView extends JFrame implements ActionListener{

	// Atributos
	JComboBox JComboBox;
	JLabel lTitle, lNomeP, lValorUni, lTipo, lDesc, lDisponivel,lQuantidade, lId;
	JTextField tNomeP, tValorUni , tDesc,tQuantidade, tId;
	JButton bVoltar, bAlterar;
	String conteudoCombo[] = { "","Bebida", "Produto2", "Produto3", "Produto4"};
	JCheckBox cSim, cNao;
	private ResourceBundle bn = null;

	public AlterarPratoView(){
		super("Santicioli Restaurante");
		rc();

		// Container Principal
		getContentPane().setLayout(null);

		// JLabel
		lTitle      = new JLabel(bn.getString("alterariteml"));
		lNomeP      = new JLabel(bn.getString("nomeiteml"));
		lValorUni   = new JLabel(bn.getString("valorunitariol"));
		lTipo       = new JLabel(bn.getString("tipoiteml"));
		lDesc       = new JLabel(bn.getString("descricaol"));
		lDisponivel = new JLabel(bn.getString("disponivell"));
		lQuantidade = new JLabel(bn.getString("quantidadeb"));
		lId 		= new JLabel("ID:");
		
		// JTextField
		tNomeP      = new JTextField(3);
		tValorUni   = new JTextField("0.00");
		tDesc       = new JTextField(50); 
		tQuantidade = new JTextField(10);
		tId			= new JTextField(10);
		
		// JComboBox
		JComboBox = new JComboBox( conteudoCombo ); 
		JComboBox.setMaximumRowCount( 5 );

		// JButton
		bVoltar  = new JButton(bn.getString("voltarb"));
		bAlterar = new JButton(bn.getString("alterarb"));

		// Adiciona a��o aos bot�es
		bVoltar.addActionListener(this);
		bAlterar.addActionListener(this);

		// JCheckBox
		cSim = new JCheckBox(bn.getString("simrb")); 
		cNao = new JCheckBox(bn.getString("naorb"));

		// Formata o t�tulo
		lTitle.setFont(new Font("Arial", Font.BOLD, 16));

		// Adicionando no Container
		getContentPane().add(lNomeP);
		getContentPane().add(tNomeP);
		getContentPane().add(lValorUni);
		getContentPane().add(tValorUni);
		getContentPane().add(lTipo);
		getContentPane().add(JComboBox);
		getContentPane().add(lDesc);
		getContentPane().add(tDesc);
//		getContentPane().add(lDisponivel);
//		getContentPane().add(cSim);
//		getContentPane().add(cNao);
		getContentPane().add(lQuantidade);
		getContentPane().add(tQuantidade);
		getContentPane().add(bVoltar);
		getContentPane().add(bAlterar);
		getContentPane().add(lTitle);
		getContentPane().add(lId);
		getContentPane().add(tId);

		// Posi��es
		lTitle.setBounds(200, 20, 500, 25);
		lId.setBounds(75, 50, 60, 25);
		tId.setBounds(100, 50, 60, 25);
		lValorUni.setBounds(200, 50, 110, 25); 
		tValorUni.setBounds(240,50, 60, 25);
		lQuantidade.setBounds(335, 50, 500, 25);
		tQuantidade.setBounds(410, 50, 60, 25);
		lNomeP.setBounds(10, 90, 110, 25); 
		tNomeP.setBounds(100,90, 370, 25);      
		lTipo.setBounds(10, 130, 110, 25);
		JComboBox.setBounds(100, 130, 370, 25); 
		lDesc.setBounds(10, 170, 110, 25); 
		tDesc.setBounds(100, 170, 370, 100);       
//		lDisponivel.setBounds(10, 280, 500, 25); 
//		cSim.setBounds(100, 280, 60, 25);
//		cNao.setBounds(160, 280, 60, 25); 
		bVoltar.setBounds(130, 320, 110, 25); 
		bAlterar.setBounds(270, 320, 110, 25);
		

		// Configurando a tela
		setSize(500, 400);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(500,200);
		setResizable(false);
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

	// A��o dos bot�es
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == bVoltar){
			dispose();
		}

		//altera aqui para passar os dados da tela pro cad.alterar
		if(event.getSource() == bAlterar){
			//ModalTemCertezaExcluirView2 mv = new ModalTemCertezaExcluirView2();
			try{
				Cardapio cad = new Cardapio();
				int id = Integer.parseInt(tId.getText());
				String titulo = tNomeP.getText();
				String descricao = tDesc.getText();
				double valor = Double.parseDouble(tValorUni.getText());
				int quantidade = Integer.parseInt(tQuantidade.getText());
				int tipo = JComboBox.getSelectedIndex();
				cad.alterar(id, tipo, titulo, descricao, valor , quantidade);
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

	// M�todo MAIN
	public static void main(String [] args){
		AlterarPratoView c = new AlterarPratoView();
	}
}
