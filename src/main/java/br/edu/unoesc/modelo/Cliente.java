package br.edu.unoesc.modelo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements MinhaEntidade {

	private String nome;
	private String cpf;
	private String cnpj;
	private List<Carro> carros;
	
	public void adicionarCarro(Carro carro) {
		if(carros == null) {
			carros = new ArrayList<>();
		}
		carros.add(carro);
	}
}