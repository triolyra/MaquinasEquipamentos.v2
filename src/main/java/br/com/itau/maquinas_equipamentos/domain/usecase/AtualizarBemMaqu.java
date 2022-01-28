package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class AtualizarBemMaqu {

	private final BemRepository bemRepository;
	private final BemMapper bemMapper = MapperFactory.newInstance(BemMapper.class);

	@Inject
	public AtualizarBemMaqu(BemRepository bemRepository) {
		this.bemRepository = bemRepository;
	}

	public BemDto execute(BemDto bemDto) {
		if (bemDto == null)
			throw new NegocioException("O Bem DTO não pode ser nulo");
		Long maquEquiExiste = bemRepository.verificarSeExiste(bemDto.getIdBem());
		if (maquEquiExiste <= 0L) {
			log.info("Maquina_Equipamento_Nao_Encontrado={}", bemDto.toString());
			throw new BemNaoEncontradoException(bemDto.getIdBem());
		}
		log.info("Atualizando_Maquina_Equipamento={}", bemDto.toString());
		var bem = bemMapper.fromBemDto(bemDto);
		var bemAtualizado = bemRepository.atualizar(bem);
		var bemAtualizadoDto = bemMapper.toBemDto(bemAtualizado);
		return bemAtualizadoDto;
	}
}
