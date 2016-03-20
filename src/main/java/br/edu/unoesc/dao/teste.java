package br.edu.unoesc.dao;

import br.edu.unoesc.modelo.Funcionario;

public class teste {

	public static void main(String[] args) {
	//cria um funcionario
		Funcionario eta = new Funcionario("Eta123", 123);
		
		
		
		mongoDao.getDAO().inserir(eta);

	
		
		//esse eh usando o listaFuncionarios, soh retorna funcionarios . mas parece bem mais simples.
		mongoDao.getDAO().listaFuncionarios().forEach(f->{
			System.out.println(f.getNome());
		});
		
		Funcionario func = (Funcionario) mongoDao.getDAO().busca(Funcionario.class, "nome", "Eta123");
		System.out.println("Generic"+func.getNome());
		 
	}

}
