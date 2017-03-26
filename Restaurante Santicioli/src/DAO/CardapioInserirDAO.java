package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardapioInserirDAO {

	private int id , idTipoPrato , estoque;
	private String titulo, descricao;
	double valor;
	Connection conn = null;
	PreparedStatement stm = null;

	public CardapioInserirDAO()
	{
		id = 0;
		idTipoPrato = 0;
		titulo = "";
		descricao = "";
		valor = 0.00;
		estoque = 0;
	}
	public CardapioInserirDAO(int id, int idTipoPrato, String titulo, String descricao, double valor, int estoque)
	{
		setId(id);
		setIdTipoPrato(idTipoPrato);
		setTitulo(titulo);
		setDescricao(descricao);
		setValor(valor);
		setEstoque(estoque);
	}

	public void iniciarConexao() throws SQLException{
		AcessoBD bd = new AcessoBD();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
	}
	public void encerrarConexao() throws SQLException{
		stm.execute();
		conn.commit();
		stm.close();
		conn.close();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTipoPrato() {
		return idTipoPrato;
	}
	public void setIdTipoPrato(int idTipoPrato) {
		this.idTipoPrato = idTipoPrato;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public void incluir(int idTipoPrato,String titulo, String descricao, double valorUnitario, int estoque)
	{
		try
		{
			iniciarConexao();
			String sqlInsert = "INSERT INTO cardapio(idTipoPrato,titulo,descricao,valorUnitario,estoque) VALUES (?, ?, ?, ?, ?);";

			stm = conn.prepareStatement(sqlInsert);

			stm.setInt(1, idTipoPrato);
			stm.setString(2, titulo);
			stm.setString(3, descricao);
			stm.setDouble(4, valorUnitario);
			stm.setInt(5, estoque);

			encerrarConexao();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}