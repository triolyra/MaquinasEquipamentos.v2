package br.com.itau.maquinas_equipamentos.port.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class MaquEquiDto {

	private int idTipoBem = 7;
	private String idBem;
	private String idTipoMaquEqui;

	private int numeroSequencial;

	@NotNull(message = "Não pode ser nulo")
	private String numeroDeSerie;

	@NotNull(message = "Não pode ser nulo")
	private double numeroNotaFiscal;

	@NotNull(message = "Não pode ser nulo")
	private String descricaoCompl;
}
