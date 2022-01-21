package br.com.itau.maquinas_equipamentos.port.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.EnderecoEntity;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.dto.EnderecoDto;

@Mapper
public interface BemMapper {

	BemMaquEntityPK toEntityPk(String idBem);
	
	BemDto toBemDto(Bem bem);
	
	@Mapping(target= "pk.idBem", source = "idBem")
	BemEntity toBemEntity(Bem bem);
	
	EnderecoDto toEnderecoDto(Endereco endereco);
	
	@Mapping(target= "pk.idBem", source = "idBem")
	EnderecoEntity toEnderecoEntity(Endereco endereco);
	
	default Bem fromBemDto(BemDto bemDto) {
		return new Bem(
				bemDto.getIdBem(),
				bemDto.getIdTipoBem(),
				bemDto.getIdUsuarioResponsavel(),
				bemDto.getDataDoCadastro(),
				bemDto.getDataDaAlteracao(),
				bemDto.getIndicadorValorizacaoManual(),
				bemDto.getValorAtualDoBem());
	}
	
	default Bem fromBemEntity(BemEntity bemEntity) {
		return new Bem(
			bemEntity.getPk().getIdBem(),
			bemEntity.getPk().getIdTipoBem(),
			bemEntity.getIdUsuarioResponsavel(),
			bemEntity.getDataDoCadastro(),
			bemEntity.getDataDaAlteracao(),
			bemEntity.getIndicadorValorizacaoManual(),
			bemEntity.getValorAtualDoBem());
}
	
	default Endereco fromEnderecoDto(EnderecoDto enderecoDto) {
		return new Endereco(
				enderecoDto.getIdBem(),
				enderecoDto.getIdTipoBem(),
				enderecoDto.getCep(),
				enderecoDto.getLogradouro(),
				enderecoDto.getComplemento());
	}
	
	default Endereco fromEnderecoEntity(EnderecoEntity enderecoEntity) {
		return new Endereco(
				enderecoEntity.getPk().getIdBem(),
				enderecoEntity.getPk().getIdTipoBem(),
				enderecoEntity.getCep(),
				enderecoEntity.getLogradouro(),
				enderecoEntity.getComplemento());
	}
}
