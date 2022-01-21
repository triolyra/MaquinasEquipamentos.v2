package br.com.itau.maquinas_equipamentos.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.EnderecoEntity;

public interface EnderecoJpaRepository
		extends JpaRepository<EnderecoEntity, BemMaquEntityPK>, JpaSpecificationExecutor<EnderecoEntity> {

	Long findByPk(BemMaquEntityPK pk);
}