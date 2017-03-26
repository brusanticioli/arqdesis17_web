package NEGOCIO;

import DAO.PedidoSelectDAO;

public class PriorizarPedidos {
	
	public PriorizarPedidos(){
	}
	
	public String[] selecionar (){
		try{
			PedidoSelectDAO sedao = new PedidoSelectDAO();
			return sedao.selecionar();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
