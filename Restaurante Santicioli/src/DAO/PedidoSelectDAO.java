package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoSelectDAO {

	int id;
	Connection conn = null;
	PreparedStatement stm = null;

	public PedidoSelectDAO(){

	}

	public PedidoSelectDAO(int id){
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

	public String[] selecionar(int id)
	{
		String[] resultados = new String[6];
		try
		{
			iniciarConexao();
			String sqlInsert = "select * from pedidos where id = ?;";

			stm = conn.prepareStatement(sqlInsert);

			stm.setInt(1, id);

			ResultSet result = stm.executeQuery();

			while(result.next()){
				resultados[0] = result.getString(1);
				resultados[1] = result.getString(2);
				resultados[2] = result.getString(3);
				resultados[3] = result.getString(4);
				resultados[4] = result.getString(5);
				resultados[5] = result.getString(6);
			}

			encerrarConexao();
			return resultados;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}	
	}

	public String[] selecionar()
	{
		String[] resultados = new String[6];
		try
		{
			iniciarConexao();
			String sqlInsert = "select * from pedidos;";

			stm = conn.prepareStatement(sqlInsert);

			stm.setInt(1, id);

			ResultSet result = stm.executeQuery();

			while(result.next()){
				resultados[0] = result.getString(1);
				resultados[1] = result.getString(2);
				resultados[2] = result.getString(3);
				resultados[3] = result.getString(4);
				resultados[4] = result.getString(5);
				resultados[5] = result.getString(6);
			}

			encerrarConexao();
			return resultados;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}	
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
