package br.edu.unoesc.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro implements MinhaEntidade{

	private String nome;
	private String placa;
	
	public String[] vetorDados(){
		return new String[]{nome,placa};
	}
}
