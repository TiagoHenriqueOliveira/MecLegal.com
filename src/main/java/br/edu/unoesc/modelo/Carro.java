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
public class Carro implements MinhaEntidade{

	private ObjectId _id;
	private String nome;
	private String placa;
	
	public String[] vetorDados(){
		return new String[]{nome,placa};
	}

	@Override
	public ObjectId getObjectId() {
		return _id;
	}
	
	public Carro(String nome, String placa){
		this.nome = nome;
		this.placa = placa;
	}
}
