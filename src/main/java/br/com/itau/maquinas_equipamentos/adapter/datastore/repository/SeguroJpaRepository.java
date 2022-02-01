package br.com.itau.maquinas_equipamentos.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.SeguroEntity;

public interface SeguroJpaRepository
		extends JpaRepository<SeguroEntity, BemMaquEntityPK>, JpaSpecificationExecutor<SeguroEntity> {

	Long countByPk(BemMaquEntityPK pk);
}