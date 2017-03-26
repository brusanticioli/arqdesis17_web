package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoAlterarDAO {
	
	private int id , quantidade , produto, garcom;
	private String dataEntrada, dataSaida;
	
	Connection conn = null;
	PreparedStatement stm = null;
	
	public PedidoAlterarDAO()
	{
		id = 0;
		quantidade = 0;
		produto = 0;
		garcom = 0;
		dataEntrada = "";
		dataSaida = "";
	}
	public PedidoAlterarDAO(int id, int quantidade, int  produto, int garcom, String dataEntrada, String dataSaida)
	{
		setId(id);
		setProduto(quantidade);
		setQuantidade(produto);
		setGarcom(garcom);
		setDataEntrada(dataEntrada);
		setDataSaida(dataSaida);
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
	
	public void alterar(int id, int quantidade, int  produto, int garcom, String dataEntrada, String dataSaida)
	{
		try
		{
			iniciarConexao();
			String sqlInsert = "update pedidos set produto = ?, quantidade = ?, garcom = ?, dataEntrada = ?, dataSaida = ? where id = ?;";

			stm = conn.prepareStatement(sqlInsert);

			stm.setInt(1, produto);
			stm.setInt(2, quantidade);
			stm.setInt(3, garcom);
			stm.setString(4, dataEntrada);
			stm.setString(5, dataSaida);
			stm.setInt(6, id);

			encerrarConexao();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public int getGarcom() {
		return garcom;
	}
	public void setGarcom(int garcom) {
		this.garcom = garcom;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
}
