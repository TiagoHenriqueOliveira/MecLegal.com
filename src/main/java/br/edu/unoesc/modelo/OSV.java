package br.edu.unoesc.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class OSV implements MinhaEntidade {
	
	private Cliente cliente;
	private TipoServico tipoServico;
	private LocalDate dataServico;
	
	
}