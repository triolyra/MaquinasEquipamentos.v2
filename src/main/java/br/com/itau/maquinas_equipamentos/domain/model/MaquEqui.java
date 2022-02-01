package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaquEqui {

	public MaquEqui(String idBem, String idTipoBem, String idTipoMaquEqui, String numeroDeSerie,
			double numeroNotaFiscal, String descricaoCompl) {
		this.idBem = idBem;
		this.idTipoBem = idTipoBem;
		this.idTipoMaquEqui = idTipoMaquEqui;
		this.numeroDeSerie = numeroDeSerie;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.descricaoCompl = descricaoCompl;
	}

	private String idBem;
	private String idTipoBem;
	private String idTipoMaquEqui;
	private int numeroSequencial;
	private String numeroDeSerie;
	private double numeroNotaFiscal;
	private String descricaoCompl;
}
