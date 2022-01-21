package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.dto.EnderecoDto;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemRepository;
import br.com.itau.maquinas_equipamentos.port.repository.EnderecoRepository;

@Named
public class IncluirBemMaqu {

	private final BemRepository bemRepository;
	private final EnderecoRepository enderecoRepository;
	private final BemMapper bemMapper = MapperFactory.newInstance(BemMapper.class);

	@Inject
	public IncluirBemMaqu(BemRepository bemRepository, EnderecoRepository enderecoRepository) {
		this.bemRepository = bemRepository;
		this.enderecoRepository = enderecoRepository;
	}
	
	public BemDto execute(BemDto bemDto) {
		if (bemDto == null)
			throw new NegocioException("O bem DTO não pode ser nulo");

		var bem = bemMapper.fromBemDto(bemDto);
		var bemSalvo = bemRepository.incluir(bem);
		var bemSalvoDto = bemMapper.toBemDto(bemSalvo);
		return bemSalvoDto;
	}

	public EnderecoDto execute(EnderecoDto enderecoDto) {
		if (enderecoDto == null)
			throw new NegocioException("O endereço DTO não pode ser nulo");

		var endereco = bemMapper.fromEnderecoDto(enderecoDto);
		var enderecoSalvo = enderecoRepository.incluir(endereco);
		var enderecoSalvoDto = bemMapper.toEnderecoDto(enderecoSalvo);
		return enderecoSalvoDto;
	}
}
