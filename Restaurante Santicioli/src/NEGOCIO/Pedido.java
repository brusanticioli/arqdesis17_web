package NEGOCIO;

import java.sql.Connection;

import javax.swing.JOptionPane;

import DAO.PedidoAlterarDAO;
import DAO.PedidoExcluirDAO;
import DAO.PedidoInserirDAO;
import DAO.PedidoSelectDAO;

public class Pedido {
	
	Connection conn = null;

	public Pedido(){
	}

	public void inserir(int id, int quantidade, int  produto, int garcom, String dataEntrada, String dataSaida){
		try{		
			PedidoInserirDAO indao = new PedidoInserirDAO();
			indao.incluir(id,quantidade,produto,garcom,dataEntrada,dataSaida);
			JOptionPane.showMessageDialog(null, "Pedido inserirdo com sucesso");
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void excluir (int id){
		try{
			PedidoExcluirDAO exdao = new PedidoExcluirDAO();
			exdao.excluir(id);
			JOptionPane.showMessageDialog(null, "Pedido excluido com sucesso");
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void alterar (int id, int quantidade, int  produto, int garcom, String dataEntrada, String dataSaida){
		try{
			PedidoAlterarDAO aldao = new PedidoAlterarDAO();
			aldao.alterar(id,quantidade,produto,garcom,dataEntrada,dataSaida);
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public String[] selecionar (int id){
		try{
			PedidoSelectDAO sedao = new PedidoSelectDAO();
			return sedao.selecionar(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
