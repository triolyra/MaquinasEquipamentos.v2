package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.dto.EnderecoDto;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.dto.SeguroDto;
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
	
	public MaquEquiDto execute(MaquEquiDto maquEquiDto) {
		if (maquEquiDto == null)
			throw new NegocioException("O bem máquina e equipamento DTO não pode ser nulo");

		var maquEqui = bemMaquEquiMapper.fromMaquEquiDto(maquEquiDto);
		var maquEquiSalvo = bemMaquEquiRepository.incluir(maquEqui);
		var maquEquiSalvoDto = bemMaquEquiMapper.toMaquEquiDto(maquEquiSalvo);
		return maquEquiSalvoDto;
	}
	
	public EnderecoDto execute(EnderecoDto enderecoDto) {
		if (enderecoDto == null)
			throw new NegocioException("O endereço DTO não pode ser nulo");

		var endereco = bemMaquEquiMapper.fromEnderecoDto(enderecoDto);
		var enderecoSalvo = bemMaquEquiRepository.incluir(endereco);
		var enderecoSalvoDto = bemMaquEquiMapper.toEnderecoDto(enderecoSalvo);
		return enderecoSalvoDto;
	}
	
	public SeguroDto execute(SeguroDto seguroDto) {
		if (seguroDto == null)
			throw new NegocioException("O seguro DTO não pode ser nulo");
		
		var seguro = bemMaquEquiMapper.fromSeguroDto(seguroDto);
		var seguroSalvo = bemMaquEquiRepository.incluir(seguro);
		var seguroSalvoDto = bemMaquEquiMapper.toSeguroDto(seguroSalvo);
		return seguroSalvoDto;
	}
}