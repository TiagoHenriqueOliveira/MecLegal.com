package br.edu.unoesc.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends MinhaEntidade {
	
	private String nome;
	private String cpf;
	private Integer cracha;
	
	public String[] vetorDados(){
		return new String[]{cracha.toString(), nome, cpf};
	}


}