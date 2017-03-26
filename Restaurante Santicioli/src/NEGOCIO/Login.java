package NEGOCIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import javax.swing.JOptionPane;

public class Login {
	
	String nome , cpf , email , login , senha , cargo;
	ArrayList <String> vLogin;
	ArrayList <String> vSenha;
	ArrayList <String> vCargo;
	ArrayList <String> vGeral;
	
	public Login(){
		vLogin  = new <String> ArrayList();
		vSenha  = new <String> ArrayList();
		vCargo  = new <String> ArrayList();
		vGeral  = new <String> ArrayList();
	}
	
	public Login(String n, String c, String e, String l,String s,String ca){
		
	}
	//sets
	   public void setNome(String n){
	      nome = n;
	   }
	   public void setCpf(String c){
	      cpf = c;
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
	   public String getNome(){
	      return nome;
	   }
	   public String getCpf(){
	      return cpf;
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
