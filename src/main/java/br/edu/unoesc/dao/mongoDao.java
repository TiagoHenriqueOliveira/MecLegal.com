package br.edu.unoesc.dao;

import java.util.ArrayList;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.MongoClient;

import br.edu.unoesc.modelo.Cliente;
import br.edu.unoesc.modelo.Funcionario;
import br.edu.unoesc.modelo.OSV;
import br.edu.unoesc.modelo.TipoServico;

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

//Funcao pra retornar lista de Todos;
	public ArrayList<Funcionario> listaFuncionarios() {
		MongoCursor<Funcionario> cursorFuncionarios = jongo.getCollection("br.edu.unoesc.modelo.Funcionario").find()
				.as(Funcionario.class);

		ArrayList<Funcionario> arrayFuncionarios = new ArrayList<Funcionario>();
		cursorFuncionarios.forEach(funcionario -> {
			arrayFuncionarios.add(funcionario);
		});

		return arrayFuncionarios;
	}
	
	public ArrayList<Cliente> listaClientes(){
		MongoCursor<Cliente> cursorClientes = jongo.getCollection("br.edu.unoesc.modelo.Cliente").find()
				.as(Cliente.class);

		ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
		cursorClientes.forEach(cliente -> {
			arrayClientes.add(cliente);
		});

		return arrayClientes;
	}
	
	public ArrayList<OSV> listaOSVs(){
		MongoCursor<OSV> cursorOSV = jongo.getCollection("br.edu.unoesc.modelo.OSV").find()
				.as(OSV.class);
		ArrayList<OSV> arrayOSV = new ArrayList<OSV>();
		cursorOSV.forEach(osv->{
			arrayOSV.add(osv);
		});
		return arrayOSV;
	}
	
	public ArrayList<TipoServico> listaTipoServicos(){
		MongoCursor<TipoServico> cursorTipoServicos = jongo.getCollection("br.edu.unoesc.modelo.TipoServico").find()
				.as(TipoServico.class);
		ArrayList<TipoServico> arrayTipoServicos = new ArrayList<TipoServico>();
		cursorTipoServicos.forEach(tipo->{
			arrayTipoServicos.add(tipo);
		});
		return arrayTipoServicos;
	}
	
	
	
	public Funcionario buscaFuncionario(String campo, String valor){
MongoCollection collectionFuncionario = jongo.getCollection("br.edu.unoesc.modelo.Funcionario");
//Vai retornar um Funcionario se o campo e o valor estiverem exatamentes iguais ao que esta salvo no banco,
	Funcionario funcionario = collectionFuncionario.findOne("{"+campo+":'"+valor+"'}").as(Funcionario.class);
	return funcionario;
	}
	
	
/*
 * Busca generica, voce passa a classe, o campo e o valor e ele retorna, precisa fazer cast dai la onde ta usando	
 */
	public Object busca(Class classe, String campo, String valor){
		MongoCollection collection = jongo.getCollection(classe.getName());
		Object objeto = collection.findOne("{"+campo+":'"+valor+"'}").as(classe);
		return objeto;
	}
	

/* 
Funcao Generica para inserir no banco de dados.
Ele salva com o nome completo, exemplo: br.edu.unoesc.modelo.Funcionario seria a collection de Funcionario
*/
	public void inserir(Object objeto) {
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		collection.insert(objeto);
	}

}
