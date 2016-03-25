package br.edu.unoesc.modelo;

import java.text.DecimalFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoServico implements MinhaEntidade{
	
	private String nome;
	private Double valor;
	
	
public String[] listaDados(){
	return new String[]{nome,new DecimalFormat("R$ #,##0.00").format(valor).toString()}; 
}
}