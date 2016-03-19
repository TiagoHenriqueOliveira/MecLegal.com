package br.edu.unoesc.dao;

import java.util.ArrayList;

import br.edu.unoesc.modelo.Funcionario;

public class teste {

	public static void main(String[] args) {
	
		Funcionario eta = new Funcionario("Eta123", 123);
		
		mongoDao.getDAO().inserir(eta);
	
		ArrayList<Funcionario> array = (ArrayList<Funcionario>) mongoDao.getDAO().listaTodos(Funcionario.class);
	
		array.forEach(etaxx->{
			System.out.println(etaxx.getNome());
		});
		
		
		mongoDao.getDAO().listaFuncionarios().forEach(f->{
			System.out.println(f.getNome());
		});
		
	}

}
