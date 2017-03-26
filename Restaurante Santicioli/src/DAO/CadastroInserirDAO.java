package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroInserirDAO {

	private int id , codigo;
	private String nome, login, senha,cargo,email;
	Connection conn = null;
	PreparedStatement stm = null;

	public CadastroInserirDAO()
	{
		id = 0;
		nome = "";
		codigo = 0;
		login = "";
		senha = "";
		cargo = "";
	}
	public CadastroInserirDAO(int id, String nome, int codigo,String email, String login, String senha, String cargo)
	{
		setId(id);
		setNome(nome);
		setCodigo(codigo);
		setEmail(email);
		setLogin(login);
		setSenha(senha);
		setCargo(cargo);
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

	public void incluir(String nome,int codigo,String email, String login, int senha, int cargo)
	{
		try
		{
			iniciarConexao();
			String sqlInsert = "INSERT INTO funcionarios(nome,codigo,email,login,senha,cargo) VALUES (?, ?, ?, ?, ?, ?);";

			stm = conn.prepareStatement(sqlInsert);

			stm.setString(1, nome);
			stm.setInt(2, codigo);
			stm.setString(3, email);
			stm.setString(4, login);
			stm.setInt(5, senha);
			stm.setInt(6, cargo);

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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
