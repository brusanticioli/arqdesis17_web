package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import NEGOCIO.Cardapio;

public class CardapioSelectDAO {
	
	int id , idPrato, estoque;
	String titulo , descricao;
	double valor;
	Connection conn = null;
	PreparedStatement stm = null;
	
	public CardapioSelectDAO(){
		
	}
	
	public CardapioSelectDAO(int id){
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
			String sqlInsert = "select * from cardapio where id = ?;";

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
	
	public List<Cardapio> seleciona()
	{
		List<Cardapio> produto = new ArrayList();
		
		try
		{
			iniciarConexao();
			String sqlInsert = "select * from cardapio;";

			stm = conn.prepareStatement(sqlInsert);
			
			ResultSet result = stm.executeQuery();
			
			while(result.next()){
				Cardapio car = new Cardapio();
				car.setId(result.getInt("id"));
				car.setIdPrato(result.getInt("idTipoPrato"));
				car.setTitulo(result.getString("titulo"));
				car.setDescricao(result.getString("descricao"));
				car.setValor(result.getDouble("valorUnitario"));
				car.setEstoque(result.getInt("estoque"));
				produto.add(car);
			}

			encerrarConexao();
			return produto;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}	
	}
	
	public List<Cardapio> seleciona(int id)
	{
		List<Cardapio> produto = new ArrayList();
		
		try
		{
			iniciarConexao();
			String sqlInsert = "select * from cardapio where id = ?;";

			stm = conn.prepareStatement(sqlInsert);
			
			stm.setInt(1, id);
			
			ResultSet result = stm.executeQuery();
			
			while(result.next()){
				Cardapio car = new Cardapio();
				car.setId(result.getInt("id"));
				car.setIdPrato(result.getInt("idTipoPrato"));
				car.setTitulo(result.getString("titulo"));
				car.setDescricao(result.getString("descricao"));
				car.setValor(result.getDouble("valorUnitario"));
				car.setEstoque(result.getInt("estoque"));
				produto.add(car);
			}

			encerrarConexao();
			return produto;
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
	public int getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
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
}
