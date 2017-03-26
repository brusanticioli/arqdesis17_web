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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CardapioSelectDAO;
import NEGOCIO.Cardapio;

public class ConsultarPratoView extends JFrame implements ActionListener
{
	// Atributos
	private JButton bVoltar ,bBuscar, bOk;
	private JLabel label;
	private JTextField tPrato;
	private ResourceBundle bn = null;
	private DefaultTableModel modelo;
	private JTable table;
	private JScrollPane bar;
	private JPanel background;

	public ConsultarPratoView()
	{
		super("Santicioli Restaurante");
		rc();

		// JLabel
		label    = new JLabel(bn.getString("consultaritemb"));

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
		
		// JtextField
		tPrato   = new JTextField(bn.getString("consultaritemt"));

		// Container Principal
		getContentPane().setLayout(null);

		// JButton
		bVoltar     = new JButton(bn.getString( "voltarb"));
		bBuscar     = new JButton(bn.getString( "buscarb"));
		bOk         = new JButton(bn.getString( "okb"));

		// Ativar Bot�es
		bVoltar.addActionListener(this);
		bBuscar.addActionListener(this);
		bOk.addActionListener(this);

		// Formata o t�tulo
		label.setFont(new Font("Arial", Font.BOLD, 16));

		// Adicionando no Container
		getContentPane().add(label);
		getContentPane().add(bVoltar);
		getContentPane().add(bBuscar);
		getContentPane().add(tPrato);
		getContentPane().add(bOk);
		getContentPane().add(background);

		// Posi��es 
		label.setBounds(200, 10, 500, 15); 
		bVoltar.setBounds(150, 320, 100, 25); 
		bBuscar.setBounds(270, 320, 100, 25); 
		tPrato.setBounds(10, 50, 400, 25); 
		background.setBounds(10, 90, 460, 200);  

		// Configurando a tela
		setSize(500, 400);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(500,200); 
		setResizable(false);
	}

	// A��o dos bot�es
	public void actionPerformed( ActionEvent event )
	{
		if(event.getSource() == bVoltar){
			dispose();
		}

		//altera aqui para passar os dados da tela pro cad.selecionar
		if(event.getSource() == bBuscar){
			try{
				int id = Integer.parseInt(tPrato.getText());
				pegaArray(id);
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
	
	public void pegaArray (int id){
		CardapioSelectDAO prodDAO = new CardapioSelectDAO();
		List<Cardapio> prods = prodDAO.seleciona(id);
		for (Cardapio produto : prods) {
			modelo.addRow(new Object[]{produto.getId(),produto.getIdPrato(),produto.getTitulo(),produto.getDescricao(),produto.getValor(),produto.getEstoque()});		
		}
	}
	
	// M�todo MAIN
	public static void main(String args[]) 
	{ 
		ConsultarPratoView view = new ConsultarPratoView();
		view.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	} 

}
