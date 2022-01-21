package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Endereco {

	public Endereco(String idBem, int idTipoBem, String cep, String logradouro, String complemento) {
		this.idBem = idBem;
		this.idTipoBem = idTipoBem;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}
	
	private String idBem; // pk (chave estrangeira que extende de bem)
	private int idTipoBem; // fk
	
	private String cep;
	private String logradouro;
	private String complemento;
	
}
