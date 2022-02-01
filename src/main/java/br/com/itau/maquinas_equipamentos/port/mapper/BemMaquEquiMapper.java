package br.com.itau.maquinas_equipamentos.port.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.EnderecoEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.SeguroEntity;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;
import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;
import br.com.itau.maquinas_equipamentos.domain.model.Seguro;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.dto.EnderecoDto;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.dto.SeguroDto;

@Mapper
public interface BemMaquEquiMapper {

	@Mapping(target = "idTipoBem", ignore = true)
	BemMaquEntityPK toEntityPk(String idBem);

	BemDto toBemDto(Bem bem);

	MaquEquiDto toMaquEquiDto(MaquEqui maquEqui);

	EnderecoDto toEnderecoDto(Endereco endereco);

	SeguroDto toSeguroDto(Seguro seguro);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	BemEntity toBemEntity(Bem bem);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	MaquEquiEntity toMaquEquiEntity(MaquEqui maquEqui);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	EnderecoEntity toEnderecoEntity(Endereco endereco);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	SeguroEntity toSeguroEntity(Seguro seguro);

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

	default MaquEqui fromMaquEquiDto(MaquEquiDto maquEquiDto) {
		return new MaquEqui(maquEquiDto.getIdBem(), maquEquiDto.getIdTipoBem(), maquEquiDto.getIdTipoMaquEqui(),
				maquEquiDto.getDescricaoCompl(), maquEquiDto.getNumeroDeSerie(), maquEquiDto.getNumeroNotaFiscal(),
				maquEquiDto.getNumeroSequencial());
	}

	default MaquEqui fromMaquEquiEntity(MaquEquiEntity maquEquiEntity) {
		return new MaquEqui(maquEquiEntity.getPk().getIdBem(), maquEquiEntity.getPk().getIdTipoBem(),
				maquEquiEntity.getIdTipoMaquEqui(), maquEquiEntity.getDescricaoCompl(),
				maquEquiEntity.getNumeroDeSerie(), maquEquiEntity.getNumeroNotaFiscal(),
				maquEquiEntity.getNumeroSequencial());
	}

	default Endereco fromEnderecoDto(EnderecoDto enderecoDto) {
		return new Endereco(enderecoDto.getIdBem(), enderecoDto.getIdTipoBem(), enderecoDto.getCep(),
				enderecoDto.getLogradouro(), enderecoDto.getComplemento());
	}

	default Endereco fromEnderecoEntity(EnderecoEntity enderecoEntity) {
		return new Endereco(enderecoEntity.getPk().getIdBem(), enderecoEntity.getPk().getIdTipoBem(),
				enderecoEntity.getCep(), enderecoEntity.getLogradouro(), enderecoEntity.getComplemento());
	}

	default Seguro fromSeguroDto(SeguroDto seguroDto) {
		return new Seguro(seguroDto.getIdBem(), seguroDto.getIdTipoBem(), seguroDto.getDataFimApolice(),
				seguroDto.getDataInicioApolice(), seguroDto.getDataRenovacaoApolice(),
				seguroDto.getIndicadorBeneficiarioSeguradora(), seguroDto.getNomeSeguradora(),
				seguroDto.getNumeroApoliceSeguro(), seguroDto.getNumeroCpfOuCnpjSeguradora());

	}

	default Seguro fromSeguroEntity(SeguroEntity seguroEntity) {
		return new Seguro(seguroEntity.getPk().getIdBem(), seguroEntity.getPk().getIdTipoBem(),
				seguroEntity.getDataFimApolice(), seguroEntity.getDataInicioApolice(),
				seguroEntity.getDataRenovacaoApolice(), seguroEntity.getIndicadorBeneficiarioSeguradora(),
				seguroEntity.getNomeSeguradora(), seguroEntity.getNumeroApoliceSeguro(),
				seguroEntity.getNumeroCpfOuCnpjSeguradora());
	}
}