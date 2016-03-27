package br.edu.unoesc.dao;

import br.edu.unoesc.modelo.MinhaEntidade;

public interface GenericDao<T extends MinhaEntidade> {
	
	public void salvar(T objeto);
	
	public void update(T objeto, String campo, String valor);
	
	public void remove (T objeto, String campo, String valor);

}
