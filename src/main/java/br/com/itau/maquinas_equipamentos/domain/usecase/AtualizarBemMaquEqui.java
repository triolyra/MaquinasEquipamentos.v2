package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemMaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemMaquEquiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class AtualizarBemMaquEqui {

	private final BemMaquEquiRepository bemMaquEquiRepository;
	private final BemMaquEquiMapper bemMaquEquiMapper = MapperFactory.newInstance(BemMaquEquiMapper.class);

	@Inject
	public AtualizarBemMaquEqui(BemMaquEquiRepository bemMaquEquiRepository) {
		this.bemMaquEquiRepository = bemMaquEquiRepository;
	}

	public BemDto execute(BemDto bemDto) {
		if (bemDto == null)
			throw new NegocioException("O Bem DTO não pode ser nulo");
		Long maquEquiExiste = bemMaquEquiRepository.verificarSeExiste(bemDto.getIdBem());
		if (maquEquiExiste <= 0L) {
			log.info("Maquina_Equipamento_Nao_Encontrado={}", bemDto.toString());
			throw new BemMaquEquiNaoEncontradoException(bemDto.getIdBem());
		}
		log.info("Atualizando_Maquina_Equipamento={}", bemDto.toString());
		var bem = bemMaquEquiMapper.fromBemDto(bemDto);
		var bemAtualizado = bemMaquEquiRepository.atualizar(bem);
		var bemAtualizadoDto = bemMaquEquiMapper.toBemDto(bemAtualizado);
		return bemAtualizadoDto;
	}
}