package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pessoa {

	private String idContratoPessoa; // pk
	private int idTipoRelacionamentoGarantiaPessoa; // sempre vai ser 10, terceiro garantidor

	private double cpfOuCnpj;
	private String nome;
	private String email;
	private int dddTelefone;
	private double telefone;
}
