package br.edu.unoesc.dao;

import java.util.ArrayList;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.MongoClient;

import br.edu.unoesc.modelo.MinhaEntidade;
import lombok.Getter;
@Getter
public class mongoDao implements GenericDao{
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
	
	public ArrayList<?> listaGenerica(Class classe, String campo, String texto){
		System.out.println(classe.getName());
		System.out.println(campo);
		System.out.println(texto);

		MongoCursor<?> cursor = jongo.getCollection(classe.getName())
				.find("{"+campo+":{$regex: #}}", texto+"*").as(classe);
				
	ArrayList array = new ArrayList<>();
	
	cursor.forEach(retornado->{
		array.add(retornado);
	});

	return array;
	
	}
/*
 * Busca generica, voce passa a classe, o campo e o valor e ele retorna, precisa fazer cast dai la onde ta usando	
 */
	public Object buscaGenerica(Class classe, String campo, String valor){
		MongoCollection collection = jongo.getCollection(classe.getName());
		Object objeto = collection.findOne("{"+campo+":'"+valor+"'}").as(classe);
		return objeto;
	}
	public Object buscaGenerica(Class classe, String campo, Integer valor){
		MongoCollection collection = jongo.getCollection(classe.getName());
		Object objeto = collection.findOne("{"+campo+":"+valor+"}").as(classe);
		return objeto;
	}
	

/* 
Funcao Generica para inserir no banco de dados.
Ele salva com o nome completo, exemplo: br.edu.unoesc.modelo.Funcionario seria a collection de Funcionario
*/
	@Override
	public void salvar(MinhaEntidade objeto) {
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		collection.insert(objeto);
	}
	public void update(MinhaEntidade objeto, String campo, String valor){
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		collection.update("{"+campo+":'"+valor+"'}").with(objeto);
	}

}
