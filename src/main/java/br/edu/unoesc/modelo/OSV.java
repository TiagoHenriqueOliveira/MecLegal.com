package br.edu.unoesc.modelo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class OSV extends MinhaEntidade {

	private Cliente cliente;
	private Carro carro;
	private Funcionario funcionario;
	private TipoServico tipoServico;
	private Date dataServico;
	
	public void setDataServico(LocalDate dataCriacao){
		Instant instant = dataCriacao.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		this.dataServico = date;
	}
	
	public LocalDate pegaData(){
		return dataServico.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	
	
	public OSV(Cliente cliente, Carro carro, Funcionario funcionario, TipoServico tipo, LocalDate data){
		this.cliente = cliente;
		this.carro = carro;
		this.funcionario = funcionario;
		this.tipoServico = tipo;
		setDataServico(data);
	}
	
	public String[] vetorDados(){
		return new String[]{cliente.getNome(), tipoServico.getNome(), carro.getNome(), pegaData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()};
	}

}