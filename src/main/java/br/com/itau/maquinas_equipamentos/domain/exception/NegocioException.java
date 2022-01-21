package br.com.itau.maquinas_equipamentos.domain.exception;

@SuppressWarnings("serial")
public class NegocioException extends RuntimeException {
	public NegocioException(String mensagem) {
		super(mensagem);
	}
}
