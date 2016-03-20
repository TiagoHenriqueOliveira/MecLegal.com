package br.edu.unoesc.validaConteudo;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ConteudoAlfaNumerico extends PlainDocument {
	
	/*
	 * Objetivo dessa classe é para validar campos que irão números, letras e acentos.
	 */

	private static final long serialVersionUID = 1L;

	public void insertString(int offset, String string, javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
		super.insertString(offset, string.toUpperCase(), setAtributo);
	}

	public void replace(int offset, String string, javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
		super.insertString(offset, string.toUpperCase(), setAtributo);
	}
}
