package br.edu.unoesc.modelo;

import java.text.DecimalFormat;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoServico extends MinhaEntidade{
	
	private ObjectId _id;
	private String nome;
	private Double valor;
	
	public String[] listaDados() {
		return new String[]{nome,new DecimalFormat("R$ #,##0.00").format(valor).toString()}; 
	}

	@Override
	public ObjectId getObjectId() {
		// TODO Auto-generated method stub
		return null;
	}
}