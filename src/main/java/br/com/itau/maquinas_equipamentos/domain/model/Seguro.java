package br.com.itau.maquinas_equipamentos.domain.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Seguro {

	private String idBem;
	private int idTipoBem;

	private String nomeSeguradora;
	private double numeroCpfOuCnpjSeguradora;
	private double numeroApoliceSeguro;
	private char indicadorBeneficiarioSeguradora;
	private LocalDate dataInicioApolice;
	private LocalDate dataFimApolice;
	private LocalDate dataRenovacaoApolice;
}
