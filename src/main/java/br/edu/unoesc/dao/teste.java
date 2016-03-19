package br.edu.unoesc.dao;

import java.util.ArrayList;

import br.edu.unoesc.modelo.Funcionario;

public class teste {

	public static void main(String[] args) {
	//cria um funcionario
		Funcionario eta = new Funcionario("Eta123", 123);
		
		//simplesmente insere o mesmo no banco, usamos o mongoDao.getDAO() sem precisa instanciar
		// um maldito new mongoDao toda vez.
		mongoDao.getDAO().inserir(eta);
	
		//aqui como usa o metodo ListaTodos do mongoDao, do modo bem generico. Porem tem que digitar muito toda vez;/
		//da pra usar pra qualquer'classe, soh no lugar de mandar o Funcionario e o Funcionario.class . 
		// Usei um cast. Como temos poucas classes acho que nao eh vantagem usarmos o mesmo.
		// Melhor nos fazer pra cada um seu especifico.
		ArrayList<Funcionario> array = (ArrayList<Funcionario>) mongoDao.getDAO().listaTodos(Funcionario.class);
	
		array.forEach(etaxx->{
			System.out.println(etaxx.getNome());
		});
		
		
		//esse eh usando o listaFuncionarios, soh retorna funcionarios . mas parece bem mais simples.
		mongoDao.getDAO().listaFuncionarios().forEach(f->{
			System.out.println(f.getNome());
		});
		
	}

}
