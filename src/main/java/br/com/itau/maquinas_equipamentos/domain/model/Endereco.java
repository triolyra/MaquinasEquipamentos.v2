package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Endereco {

	public Endereco(String idBem, int idTipoBem, String cep, String logradouro, String complemento) {
	}
	
	private String idBem;
	private int idTipoBem;

	private String cep;
	private String logradouro;
	private String complemento;
}
