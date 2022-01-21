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
@JsonIgnoreProperties(ignoreUnknown = true) //pra que serve???
@ToString //pra que serve???
@EqualsAndHashCode //pra que serve???
public class MaquEquiDto {
	
	//private String idGarantia;
		private String idBem;
		private String idTipoBem;
		private String idTipoMaquEqui;
		
		//private int finalidadeDeUso;
		//private int numeroIdentificador;
		
		@NotNull (message = "Não pode ser nulo")
		private String numeroDeSerie;
		
		@NotNull (message = "Não pode ser nulo")
		private double numeroNotaFiscal;
		//private String dataNotaFiscal;
		
		@NotNull (message = "Não pode ser nulo")
		private String descricaoCompl;
		
}
