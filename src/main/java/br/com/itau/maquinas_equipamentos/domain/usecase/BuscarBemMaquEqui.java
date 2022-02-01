package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemMaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemMaquEquiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class BuscarBemMaquEqui {

	private final BemMaquEquiRepository bemMaquEquiRepository;
	private final BemMaquEquiMapper bemMaquEquiMapper = MapperFactory.newInstance(BemMaquEquiMapper.class);

	@Inject
	public BuscarBemMaquEqui(BemMaquEquiRepository bemMaquEquiRepository) {
		this.bemMaquEquiRepository = bemMaquEquiRepository;
	}

	public BemDto execute(String idBem) {
		log.info("Buscando_MaquEqui_Por_ID=idBem={}", idBem);
		var bemOptional = bemMaquEquiRepository.consultarPorId(idBem);
		if (bemOptional.isEmpty()) {
			log.info("MaquEqui_Nao_Encontrada=idBem={}", idBem);
			throw new BemMaquEquiNaoEncontradoException(idBem);
		}
		return bemMaquEquiMapper.toBemDto(bemOptional.get());
	}

	public BemDto execute(BemDto bemDto) {
		// TODO Auto-generated method stub
		return bemDto;
	}
}