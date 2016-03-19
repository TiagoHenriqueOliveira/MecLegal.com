package br.edu.unoesc.dao;

import java.util.ArrayList;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.MongoClient;

import br.edu.unoesc.modelo.Funcionario;

public class mongoDao {
	private static mongoDao mg;
	private Jongo jongo;

	//funcao statica para nao precisar instanciar o mongoDao para usarmos durante o programa
	public static mongoDao getDAO() {
		if (mg == null) {
			mg = new mongoDao();
		}
		return mg;
	}
//metodo construtor do mongoDao
	public mongoDao() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		jongo = new Jongo(mongoClient.getDB("meclegal"));
	}

//Funcao pra retornar uma ListadeFuncionarios em especifico
	public ArrayList<Funcionario> listaFuncionarios() {
		MongoCursor<Funcionario> cursor = jongo.getCollection("br.edu.unoesc.modelo.Funcionario").find()
				.as(Funcionario.class);

		ArrayList<Funcionario> func = new ArrayList<Funcionario>();
		//esse forEach eh pra adicionar os itens do cursor em um array e retornar o mesmo
		//Nao achei um jeito mais facil de converter um MongoCursor em um array.
		cursor.forEach(f -> {
			func.add(f);
		});

		return func;
	}

//Essa funcao listaTodos é bem generica, ela funciona pra qualquer classe, 
//e recebe como parametro a classe que vamos listar.
	public ArrayList<?> listaTodos(Class<?> classe) {
		MongoCollection collection = jongo.getCollection(classe.getName());
		MongoCursor<?> cursor = collection.find().as(classe);
		ArrayList array = new ArrayList();
		
		//esse forEach eh pra adicionar os itens do cursor em um array e retornar o mesmo
		//Nao achei um jeito mais facil de converter um MongoCursor em um array.
		cursor.forEach(eta -> {
			array.add(eta);
		});
		return array;
	}
	
	
//Funcao Generica para inserir no banco de dados.
//Ele salva com o nome completo: exemplo: br.edu.unoesc.modelo.Funcionario
	public void inserir(Object objeto) {
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		System.out.println(objeto.getClass().getName());
		collection.insert(objeto);
	}

}
