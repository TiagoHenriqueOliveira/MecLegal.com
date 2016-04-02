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
public class Carro extends MinhaEntidade{

	private String nome;
	private String placa;
	
	public String[] vetorDados(){
		return new String[]{nome,placa};
	}

	@Override
	public ObjectId getObjectId() {
		return new ObjectId(_id);
	}
	
}
