package br.com.itau.maquinas_equipamentos.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;

public interface MaquEquiJpaRepository
		extends JpaRepository<MaquEquiEntity, BemMaquEntityPK>, JpaSpecificationExecutor<MaquEquiEntity> {

	Long countByPk(BemMaquEntityPK pk);
}