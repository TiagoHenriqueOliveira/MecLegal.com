package br.edu.unoesc.modelo;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements MinhaEntidade {

	private ObjectId _id;
	private String nome;
	private String cpf;
	private String cnpj;
	private ArrayList<Carro> carros = new ArrayList<Carro>() ;
	
	public void adicionarCarro(Carro carro) {
		carros.add(carro);
	}
	
	public String[] vetorDados(){
		if (this.cpf.equals("   .   .   -  ")){
			return new String[]{nome,null,cnpj};	
		}
		return new String[]{nome,cpf,null};
	}

	@Override
	public ObjectId getObjectId() {
		return _id;
	}
}