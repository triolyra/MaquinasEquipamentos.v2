package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class BuscarBemMaqu {

	private final BemRepository bemRepository;
	private final BemMapper bemMapper = MapperFactory.newInstance(BemMapper.class);

	@Inject
	public BuscarBemMaqu(BemRepository bemRepository) {
		this.bemRepository = bemRepository;
	}

	public BemDto execute(String idBem) {
		log.info("Buscando_MaquEqui_Por_ID=idBem={}", idBem);
		var bemOptional = bemRepository.consultarPorId(idBem);
		if (bemOptional.isEmpty()) {
			log.info("MaquEqui_Nao_Encontrada=idBem={}", idBem);
			throw new BemNaoEncontradoException(idBem);
		}
		return bemMapper.toBemDto(bemOptional.get());
	}

	public BemDto execute(BemDto bemDto) {
		// TODO Auto-generated method stub
		return bemDto;
	}
}
