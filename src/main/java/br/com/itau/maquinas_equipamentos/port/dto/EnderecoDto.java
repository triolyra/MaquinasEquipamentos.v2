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
public class EnderecoDto {

	private String idBem;
	private int idTipoBem;
	
	private String cep;
	
	@NotNull(message = "Não pode ser nulo")
	private String logradouro;
	
	private String complemento;
	
}
