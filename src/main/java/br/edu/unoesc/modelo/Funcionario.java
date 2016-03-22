package br.edu.unoesc.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements MinhaEntidade {
	
	private String nome;
	private Integer cracha;
	
}
