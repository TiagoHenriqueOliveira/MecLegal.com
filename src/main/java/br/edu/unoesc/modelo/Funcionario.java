package br.edu.unoesc.modelo;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements MinhaEntidade {
	
	private ObjectId _id;
	private String nome;
	private String cpf;
	private Integer cracha;
	
	public String[] vetorDados(){
		return new String[]{cracha.toString(), nome, cpf};
	}

	@Override
	public ObjectId getObjectId() {
		return _id;
	}
}