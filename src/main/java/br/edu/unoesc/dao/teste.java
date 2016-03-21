package br.edu.unoesc.dao;

import br.edu.unoesc.modelo.Funcionario;

public class teste {

	public static void main(String[] args) {
	//cria um funcionario
		Funcionario eta = new Funcionario("VAMO_LA", 342437);
		
	
	mongoDao.getDAO().listaFuncionariosLike("nome", "O_L").forEach(funcionario->{
		System.out.println(funcionario.getNome());	
		System.out.println(funcionario.getCracha());
	});
		
				mongoDao.getDAO().inserir(eta);

	
		
 
	}

}
