package br.edu.unoesc.dao;

import java.util.ArrayList;

import br.edu.unoesc.modelo.Funcionario;

public class teste {

	public static void main(String[] args) {
	//cria um funcionario
		Funcionario eta = new Funcionario("VAMO_LA", 342437);
		
	
ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) mongoDao.getDAO().listaGenerica(Funcionario.class, "cracha", "123");
		

Funcionario func1 = (Funcionario) mongoDao.getDAO().buscaGenerica(Funcionario.class, "cracha", "123");

System.out.println(func1.getNome());


	
		
 
	}

}
