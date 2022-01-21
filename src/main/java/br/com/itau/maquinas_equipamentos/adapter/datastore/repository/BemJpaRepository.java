package br.com.itau.maquinas_equipamentos.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;

public interface BemJpaRepository
		extends JpaRepository<BemEntity, BemMaquEntityPK>, JpaSpecificationExecutor<BemEntity> {

	Long findByPk(BemMaquEntityPK pk);
}
