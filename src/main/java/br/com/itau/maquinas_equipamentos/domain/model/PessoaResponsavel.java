package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaResponsavel {

	private String idBem;
	private int idTipoBem;
	private String idContratoPessoa;

}
