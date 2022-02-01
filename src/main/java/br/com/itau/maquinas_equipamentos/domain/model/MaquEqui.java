package br.com.itau.maquinas_equipamentos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaquEqui {

	public MaquEqui(String idBem, int idTipoBem, String idTipoMaquEqui, String descricaoCompl,
			String numeroDeSerie, double numeroNotaFiscal, int numeroSequencial) {
		this.idBem = idBem;
		this.idTipoBem = idTipoBem;
		this.idTipoMaquEqui = idTipoMaquEqui;
		this.descricaoCompl = descricaoCompl;
		this.numeroDeSerie = numeroDeSerie;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.numeroSequencial = numeroSequencial;
	}

	private String idBem;
	private int idTipoBem;
	private String idTipoMaquEqui;
	private int numeroSequencial;
	private String numeroDeSerie;
	private double numeroNotaFiscal;
	private String descricaoCompl;
}
