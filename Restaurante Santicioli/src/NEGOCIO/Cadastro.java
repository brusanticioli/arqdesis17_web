package NEGOCIO;

import javax.swing.JOptionPane;

import DAO.CadastroInserirDAO;

public class Cadastro {

	int id, codigo;
	String nome , email , login , senha , cargo;

	//Construtores
	public Cadastro(){}

	public Cadastro (String nome,int codigo, String email, String login , String senha , String cargo){
		setNome(nome);
		setCodigo(codigo);
		setEmail(email);
		setLogin(login);
		setSenha(senha);
		setCargo(cargo);
	}

	public void inserir(String nome,int codigo,String email, String login, int senha, int cargo){
		try{		
			CadastroInserirDAO indao = new CadastroInserirDAO();
			indao.incluir(nome,codigo,email, login,senha,cargo);
			JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	//sets
	public void setId(int i){
		id = i;
	}
	public void setCodigo(int co){
		codigo = co;
	}
	public void setNome(String n){
		nome = n;
	}
	public void setEmail(String e){
		email = e;
	}
	public void setLogin(String l){
		login = l;
	}
	public void setSenha(String s){
		senha = s;
	}
	public void setCargo(String c){
		cargo = c;
	}

	//gets
	public int getId(){
		return id;
	}
	public int getCodigo(){
		return codigo;
	}
	public String getNome(){
		return nome;
	}
	public String getEmail(){
		return email;
	}
	public String getLogin(){
		return login;
	}
	public String getSenha(){
		return senha;
	}
	public String getCargo(){
		return cargo;
	}
}
