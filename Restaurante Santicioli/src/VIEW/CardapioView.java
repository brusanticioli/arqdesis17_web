package VIEW;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CardapioSelectDAO;
import NEGOCIO.Cardapio;

public class CardapioView extends JFrame implements ActionListener
{
	// Atributos
	private JButton bNovo , bConsultar , bAlterar, bExcluir;
	private JLabel label;
	private ResourceBundle bn = null;
	private DefaultTableModel modelo;
	private JTable table;
	private JScrollPane bar;
	private JPanel background;

	public CardapioView()
	{
		super("Santicioli Restaurante");
		rc();
		label    = new JLabel(bn.getString("cardapiol"));

		//table
		background = new JPanel();
		background.setLayout(new GridLayout(1, 1));
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		bar = new JScrollPane(table);

		modelo.addColumn("Id");
		modelo.addColumn(bn.getString("idtipoprato"));
		modelo.addColumn(bn.getString("titulo"));
		modelo.addColumn(bn.getString("descricao"));
		modelo.addColumn(bn.getString("valorunitario"));
		modelo.addColumn(bn.getString("estoque"));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		background.add(bar);

		// Container Principal
		getContentPane().setLayout(null);

		// JButton
		bNovo       = new JButton(bn.getString( "novob"));
		bConsultar  = new JButton(bn.getString( "consultarb"));
		bAlterar    = new JButton(bn.getString( "alterarb"));
		bExcluir    = new JButton(bn.getString( "excluirb"));

		// Adiciona ação aos botões
		bNovo.addActionListener(this);
		bConsultar.addActionListener(this);
		bAlterar.addActionListener(this);
		bExcluir.addActionListener(this);

		// Formata o título
		label.setFont(new Font("Arial", Font.BOLD, 16));

		// Adicionando no Container
		getContentPane().add(label);
		getContentPane().add(bNovo);
		getContentPane().add(bConsultar);
		getContentPane().add(bAlterar);
		getContentPane().add(bExcluir);
		getContentPane().add(background);

		// Posições 
		label.setBounds(200, 10, 500, 15); 
		bNovo.setBounds(10, 320, 110, 25); 
		bConsultar.setBounds(130, 320, 110, 25); 
		bAlterar.setBounds(250, 320, 110, 25); 
		bExcluir.setBounds(370, 320, 110, 25);
		background.setBounds(10, 60, 460, 230);  

		// Configurando a tela
		setSize(500, 400);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(500,200);   
		setResizable(false);

		pegaArray();
	}

	// Ação dos botões
	public void actionPerformed( ActionEvent event )
	{
		if(event.getSource() == bNovo){
			CadastrarPratoView car = new CadastrarPratoView();
		}
		if(event.getSource() == bConsultar){
			ConsultarPratoView ppp = new ConsultarPratoView();
		}
		if(event.getSource() == bAlterar){
			AlterarPratoView ennf = new AlterarPratoView();
		}
		if(event.getSource() == bExcluir){
			ExcluirPratoView pp = new ExcluirPratoView();
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

	public void pegaArray (){
		CardapioSelectDAO prodDAO = new CardapioSelectDAO();
		List<Cardapio> prods = prodDAO.seleciona();
		for (Cardapio produto : prods) {
			modelo.addRow(new Object[]{produto.getId(),produto.getIdPrato(),produto.getTitulo(),produto.getDescricao(),produto.getValor(),produto.getEstoque()});		
		}
	}

	// Método MAIN
	public static void main(String args[]) 
	{ 
		CardapioView view = new CardapioView();
		view.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	} 

}