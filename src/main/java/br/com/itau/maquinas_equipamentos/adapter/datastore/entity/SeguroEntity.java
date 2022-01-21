package br.com.itau.maquinas_equipamentos.adapter.datastore.entity;

import java.time.LocalDate;

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
@Table(name = "TBGG087_SEGU_BEM")
public class SeguroEntity {

	@EmbeddedId private BemMaquEntityPK pk;
	
	@Column(name = "NOM_SEGA")
	private String nomeSeguradora;

	@Column(name = "NUM_CPF_CNPJ_SEGA", nullable = false)
	private double numeroCpfOuCnpjSeguradora;

	@Column(name = "NUM_APOL_SEGU_BEM")
	private double numeroApoliceSeguro;

	@Column(name = "IND_BENF_SEGU_BEM_BANC", nullable = false)
	private char indicadorBeneficiarioSeguradora;

	@Column(name = "DAT_INIO_VIGE_APOL_SEGU_BEM", nullable = false)
	private LocalDate dataInicioApolice;

	@Column(name = "DAT_FIM_VIGE_APOL_SEGU_BEM")
	private LocalDate dataFimApolice;

	@Column(name = "DAT_RENO_APOL_SEGU_BEM")
	private LocalDate dataRenovacaoApolice;
}
