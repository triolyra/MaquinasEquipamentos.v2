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
@Table(name = "TBGG070_BEM")
public class BemEntity {

	@EmbeddedId private BemMaquEntityPK pk;

	@Column(name = "DAT_HOR_CADT_RGTO", nullable = false)
	private LocalDate dataDoCadastro;

	@Column(name = "DAT_HOR_ALTE_RGTO", nullable = false)
	private LocalDate dataDaAlteracao;

	@Column(name = "COD_USUA_RSPL_ALTE", nullable = false)
	private String idUsuarioResponsavel;

	@Column(name = "IND_VLRZ_MANU", nullable = false)
	private char indicadorValorizacaoManual;

	@Column(name = "VLR_ATUL_BEM", nullable = false)
	private double valorAtualDoBem;
}
