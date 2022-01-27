package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Endereco {
	
	private String idBem; // pk (chave estrangeira que extende de bem)
	private int idTipoBem; // fk
	
	private String cep;
	private String logradouro;
	private String complemento;
	
}
