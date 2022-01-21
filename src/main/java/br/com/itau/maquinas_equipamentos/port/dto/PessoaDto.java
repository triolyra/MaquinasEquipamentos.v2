package br.com.itau.maquinas_equipamentos.port.dto;

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
public class PessoaDto {

	private String idContratoPessoa;
	
	@NotNull(message = "Não pode ser nulo")
	private int idTipoRelacionamentoGarantiaPessoa;

	private double cpfOuCnpj;
	
	private String nome;
	
	private String email;
	
	private int dddTelefone;
	
	private double telefone;
}
