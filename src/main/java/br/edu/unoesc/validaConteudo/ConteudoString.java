package br.edu.unoesc.validaConteudo;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ConteudoString extends PlainDocument {

	/*
	 * Objetivo dessa classe é para validar campos que irão receber somente
	 * letras
	 */

	private static final long serialVersionUID = 1L;

	public void insertString(int offset, String string, javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
		super.insertString(offset, string.toUpperCase().replaceAll("[^a-z|^A-Z|^/|^&|^.|^ ]", ""), setAtributo);
	}

	public void replace(int offset, String string, javax.swing.text.AttributeSet setAtributo)
			throws BadLocationException {
		super.insertString(offset, string.toUpperCase().replaceAll("[^a-z|^A-Z|^/|^&|^.|^ ]", ""), setAtributo);
	}
}