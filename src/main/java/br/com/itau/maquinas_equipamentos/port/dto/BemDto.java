package br.com.itau.maquinas_equipamentos.port.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class BemDto {

	private int idTipoBem = 7;
	private String idBem;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate dataDoCadastro;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate dataDaAlteracao;

	@NotNull(message = "Não pode ser nulo")
	private String idUsuarioResponsavel;

	@NotNull(message = "Não pode ser nulo")
	private char indicadorValorizacaoManual;

	@NotNull(message = "Não pode ser nulo")
	private double valorAtualDoBem;
}
