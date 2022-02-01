package br.com.itau.maquinas_equipamentos.port.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;

@Mapper
public interface BemMaquEquiMapper {

	@Mapping(target = "idTipoBem", ignore = true)
	BemMaquEntityPK toEntityPk(String idBem);

	BemDto toBemDto(Bem bem);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	BemEntity toBemEntity(Bem bem);

	default Bem fromBemDto(BemDto bemDto) {
		return new Bem(bemDto.getIdBem(), bemDto.getIdTipoBem(), bemDto.getIdUsuarioResponsavel(),
				bemDto.getDataDoCadastro(), bemDto.getDataDaAlteracao(), bemDto.getIndicadorValorizacaoManual(),
				bemDto.getValorAtualDoBem());
	}

	default Bem fromBemEntity(BemEntity bemEntity) {
		return new Bem(bemEntity.getPk().getIdBem(), bemEntity.getPk().getIdTipoBem(),
				bemEntity.getIdUsuarioResponsavel(), bemEntity.getDataDoCadastro(), bemEntity.getDataDaAlteracao(),
				bemEntity.getIndicadorValorizacaoManual(), bemEntity.getValorAtualDoBem());
	}
}