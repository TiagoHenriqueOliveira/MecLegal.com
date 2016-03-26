package br.edu.unoesc.dao;

import java.util.ArrayList;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.MongoClient;

import br.edu.unoesc.modelo.MinhaEntidade;
import lombok.Getter;

@SuppressWarnings("rawtypes")
@Getter
public class MongoDao implements GenericDao {
	private static MongoDao mg;
	private Jongo jongo;

	public static MongoDao getDAO() {
		if (mg == null) {
			mg = new MongoDao();
		}
		return mg;
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public MongoDao() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		jongo = new Jongo(mongoClient.getDB("meclegal"));
	}

	// Retorna um ArrayList com todos os objetos que contem no campo passado o
	// conteudo texto passado.
	// listaGenerica exemplo em SQL: listaGenerica(select classe where campo
	// like %texto%)
	@SuppressWarnings({ "unchecked" })
	public ArrayList<?> listaGenerica(Class classe, String campo, String texto) {
		MongoCursor<?> cursor = jongo.getCollection(classe.getName()).find("{" + campo + ":{$regex: #}}", texto + "*").as(classe);

		ArrayList array = new ArrayList<>();

		cursor.forEach(retornado -> {
			array.add(retornado);
		});

		return array;
	}

	// Busca Generica, busca o valor EXATO e retorna somente 1 Objeto, se
	// existir no Banco, caso nao, retorna null.
	@SuppressWarnings({ "unchecked" })
	public Object buscaGenerica(Class classe, String campo, String valor) {
		Object objeto = jongo.getCollection(classe.getName()).findOne("{" + campo + ":'" + valor + "'}").as(classe);
		return objeto;
	}

	@SuppressWarnings({ "unchecked" })
	public Object buscaGenerica(Class classe, String campo, Integer valor) {
		Object objeto = jongo.getCollection(classe.getName()).findOne("{" + campo + ":" + valor + "}").as(classe);
		return objeto;
	}

	 // Funcao Generica para inserir no banco de dados. Ele salva com o nome
	 // completo, exemplo: br.edu.unoesc.modelo.Funcionario seria a collection de Funcionario
	 
	@Override
	public void salvar(MinhaEntidade objeto) {
		jongo.getCollection(objeto.getClass().getName()).insert(objeto);
	}

	@Override
	public void update(MinhaEntidade objeto, String campo, String valor) {
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		collection.update("{" + campo + ":'" + valor + "'}").with(objeto);
	}
}