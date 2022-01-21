package br.com.itau.maquinas_equipamentos.adapter.datastore.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBGG081_CTTO_PESS")
public class PessoaEntity {
	
	@EmbeddedId private PessoaResponsavelEntityPK pk;

	@Column(name = "COD_TIPO_RLMT_GARA_PESS", nullable = false)
	private int idTipoRelacionamentoGarantiaPessoa;

	@Column(name = "COD_TIPO_PESS_CTTO_GRUP")
	private char idTipoPessoaContratoGrupo;

	@Column(name = "NUM_CPF_CNPJ_CTTO_GRUP")
	private double cpfOuCnpjContratoGrupo;

	@Column(name = "COD_TIPO_PESS_CTT")
	private char idTipoPessoaContrato;

	@Column(name = "NUM_CPF_CNPJ_CTTO_PESS")
	private double cpfOuCnpjContratoPessoa;

	@Column(name = "NOM_CTTO_PESS")
	private String nome;

	@Column(name = "NOM_EMAI_CTTO_PESS")
	private String email;

	@Column(name = "COD_DDD_TEL_CTTO_PESS")
	private int dddTelefone;

	@Column(name = "NUM_TEL_CTTO_PESS")
	private double telefone;

}
