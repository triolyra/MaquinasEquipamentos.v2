package br.com.itau.maquinas_equipamentos.port.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class SeguroDto {

	private int idTipoBem = 7;
	private String idBem;

	private String nomeSeguradora;

	@NotNull(message = "Não pode ser nulo")
	private double numeroCpfOuCnpjSeguradora;

	private double numeroApoliceSeguro;

	@NotNull(message = "Não pode ser nulo")
	private char indicadorBeneficiarioSeguradora;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate dataInicioApolice;

	private LocalDate dataFimApolice;

	private LocalDate dataRenovacaoApolice;
}
