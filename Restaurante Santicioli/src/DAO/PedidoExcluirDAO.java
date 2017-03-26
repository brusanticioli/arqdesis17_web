package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoExcluirDAO {
	
	int id;
	Connection conn = null;
	PreparedStatement stm = null;
	
	public PedidoExcluirDAO(){
		
	}
	
	public PedidoExcluirDAO(int id){
		setId(id);
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
	
	public void excluir(int id)
	{
		try
		{
			iniciarConexao();
			String sqlInsert = "DELETE FROM pedidos WHERE idCardapio = ?;";

			stm = conn.prepareStatement(sqlInsert);

			stm.setInt(1, id);

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
}
