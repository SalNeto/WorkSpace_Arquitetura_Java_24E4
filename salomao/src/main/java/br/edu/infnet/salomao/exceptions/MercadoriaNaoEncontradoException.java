package br.edu.infnet.salomao.exceptions;

public class MercadoriaNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MercadoriaNaoEncontradoException(String message) {
		super(message);
	}
}
