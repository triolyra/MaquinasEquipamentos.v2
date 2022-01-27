package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.dto.EnderecoDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemRepository;

@Named
public class IncluirBemMaqu {

	private final BemRepository bemRepository;
	private final BemMapper bemMapper = MapperFactory.newInstance(BemMapper.class);

	@Inject
	public IncluirBemMaqu(BemRepository bemRepository) {
		this.bemRepository = bemRepository;
	}
	
	public BemDto execute(BemDto bemDto, EnderecoDto enderecoDto) {
		if (bemDto == null && enderecoDto == null)
			throw new NegocioException("O bem DTO não pode ser nulo");

		var bem = bemMapper.fromBemDto(bemDto, enderecoDto);
		var endereco = bemMapper.fromBemDto(bemDto, enderecoDto);
		var bemSalvo = bemRepository.incluir(bem, endereco);
		var bemSalvoDto = bemMapper.toBemDto(bemSalvo);
		return bemSalvoDto;
	}
}
