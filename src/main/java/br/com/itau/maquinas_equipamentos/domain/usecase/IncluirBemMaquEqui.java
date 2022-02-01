package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemMaquEquiRepository;

@Named
public class IncluirBemMaquEqui {

	private final BemMaquEquiRepository bemMaquEquiRepository;
	private final BemMaquEquiMapper bemMaquEquiMapper = MapperFactory.newInstance(BemMaquEquiMapper.class);

	@Inject
	public IncluirBemMaquEqui(BemMaquEquiRepository bemMaquEquiRepository) {
		this.bemMaquEquiRepository = bemMaquEquiRepository;
	}

	public BemDto execute(BemDto bemDto) {
		if (bemDto == null)
			throw new NegocioException("O bem DTO não pode ser nulo");

		var bem = bemMaquEquiMapper.fromBemDto(bemDto);
		var bemSalvo = bemMaquEquiRepository.incluir(bem);
		var bemSalvoDto = bemMaquEquiMapper.toBemDto(bemSalvo);
		return bemSalvoDto;
	}
}