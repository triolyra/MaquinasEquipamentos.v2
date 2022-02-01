package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pessoa {

	private String idContratoPessoa;
	private int idTipoRelacionamentoGarantiaPessoa = 10;

	private double cpfOuCnpj;
	private String nome;
	private String email;
	private int dddTelefone;
	private double telefone;
}
