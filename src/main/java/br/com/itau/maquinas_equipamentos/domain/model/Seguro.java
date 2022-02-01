package br.com.itau.maquinas_equipamentos.domain.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Seguro {

	public Seguro(String idBem, int idTipoBem, LocalDate dataFimApolice, LocalDate dataInicioApolice,
			LocalDate dataRenovacaoApolice, char indicadorBeneficiarioSeguradora, String nomeSeguradora,
			double numeroApoliceSeguro, double numeroCpfOuCnpjSeguradora) {
		// TODO Auto-generated constructor stub
	}
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
