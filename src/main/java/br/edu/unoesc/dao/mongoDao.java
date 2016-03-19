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

	public static mongoDao getDAO() {
		if (mg == null) {
			mg = new mongoDao();
		}
		return mg;
	}

	public mongoDao() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		jongo = new Jongo(mongoClient.getDB("meclegal"));
	}

	public ArrayList<Funcionario> listaFuncionarios() {
		MongoCursor<Funcionario> cursor = jongo.getCollection("br.edu.unoesc.modelo.Funcionario").find()
				.as(Funcionario.class);

		ArrayList<Funcionario> func = new ArrayList<Funcionario>();

		cursor.forEach(f -> {
			func.add(f);
		});

		return func;
	}

	public ArrayList<?> listaTodos(Class<?> classe) {
		MongoCollection collection = jongo.getCollection(classe.getName());
		MongoCursor<?> cursor = collection.find().as(classe);
		ArrayList array = new ArrayList();
		cursor.forEach(eta -> {
			array.add(eta);
		});
		return array;
	}

	public void inserir(Object objeto) {
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		System.out.println(objeto.getClass().getName());
		collection.insert(objeto);
	}

}
