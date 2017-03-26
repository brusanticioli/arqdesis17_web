package NEGOCIO;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.CardapioAlterarDAO;
import DAO.CardapioExcluirDAO;
import DAO.CardapioInserirDAO;
import DAO.CardapioSelectDAO;

public class Cardapio {

	int id , idPrato, estoque;
	String titulo , descricao;
	double valor;
	Connection conn = null;

	public Cardapio(){
	}

	public void inserir(int tipo, String descr,String cardapio,double valor,int id2){
		try{		
			CardapioInserirDAO indao = new CardapioInserirDAO();
			indao.incluir(tipo,descr, cardapio,valor,id2);
			JOptionPane.showMessageDialog(null, "Produto inserirdo com sucesso");
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void excluir (int id){
		try{
			CardapioExcluirDAO exdao = new CardapioExcluirDAO();
			exdao.excluir(id);
			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void alterar (int id, int tipo, String descr,String cardapio,double valor,int id2){
		try{
			CardapioAlterarDAO aldao = new CardapioAlterarDAO();
			aldao.alterar(id,tipo,descr, cardapio,valor,id2);
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

//	public String[] selecionar (int id){
//		try{
//			CardapioSelectDAO sedao = new CardapioSelectDAO();
//			return sedao.selecionar(id);
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}
//	}
	
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
