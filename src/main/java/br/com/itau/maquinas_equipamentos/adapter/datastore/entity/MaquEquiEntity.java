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
@Table(name = "TBGG076_BEM_MAQU")
public class MaquEquiEntity{

	@EmbeddedId private BemMaquEntityPK pk;

	@Column(name = "COD_TIPO_MAQU_EQUI", nullable = false)
	private String idTipoMaquEqui;
	
	//private int finalidadeDeUso;
	
	@Column(name = "NUM_IDEF_MAQU_EQUI", nullable = false)
	private int numeroSequencial;
	
	@Column(name = "COD_NUM_SRIE_MAQU_EQUI", nullable = false)
	private String numeroDeSerie;
	
	@Column(name = "NUM_NOTA_FISC_MAQU_EQUI", nullable = false)
	private double numeroNotaFiscal;
	//private String dataNotaFiscal;
	
	@Column(name = "DESC_CMPL_MAQU_EQUI", nullable = false)
	private String descricaoCompl;

}
