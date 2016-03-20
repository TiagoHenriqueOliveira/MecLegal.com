package br.edu.unoesc.modelo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	private String nome;
	private String cpf;
	private String cnpj;
	private ArrayList<Carro> carros = new ArrayList<Carro>();
	
}