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
@Table(name = "TBGG082_ENDE_BEM")
public class EnderecoEntity {

	@EmbeddedId private BemMaquEntityPK pk;
	
	@Column(name = "ID_CEP_LOGR_BEM")
	private String cep;

	@Column(name = "COD_NUM_LOGR_BEM", nullable = false)
	private String logradouro;

	@Column(name = "DESC_CMPL_BEM")
	private String complemento;

}
