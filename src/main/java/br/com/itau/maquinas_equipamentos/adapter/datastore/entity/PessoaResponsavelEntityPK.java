package br.com.itau.maquinas_equipamentos.adapter.datastore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PessoaResponsavelEntityPK implements Serializable {

	private static final long serialVersionUID = -9033685707900808404L;

	@Column(name = "COD_BEM", nullable = false, updatable = false)
	private String idBem;

	@Column(name = "COD_TIPO_BEM", nullable = false, updatable = false)
	private int idTipoBem;

	@Column(name = "COD_IDT_CTTO_PESS", nullable = false)
	private String idContratoPessoa;

	public String toString() {
		return "BemPessoaRespPK(" + "id_tipo_bem= " + idTipoBem + ",id_bem" + idBem + "id_contrato_pessoa"
				+ idContratoPessoa + ')';
	}
}
