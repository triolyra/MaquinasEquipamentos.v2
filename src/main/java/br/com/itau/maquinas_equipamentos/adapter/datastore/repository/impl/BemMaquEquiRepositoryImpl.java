package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.BemJpaRepository;
import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.EnderecoJpaRepository;
import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.MaquEquiJpaRepository;
import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.SeguroJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;
import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;
import br.com.itau.maquinas_equipamentos.domain.model.Seguro;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemMaquEquiRepository;

@Repository
public class BemMaquEquiRepositoryImpl implements BemMaquEquiRepository {

	@Autowired
	private BemJpaRepository bemJpaRepository;
	private MaquEquiJpaRepository maquEquiJpaRepository;
	private EnderecoJpaRepository enderecoJpaRepository;
	private SeguroJpaRepository seguroJpaRepository;

	private final BemMaquEquiMapper bemMaquEquiMapper = MapperFactory.newInstance(BemMaquEquiMapper.class);

	@Override
	public Bem incluir(Bem bem) {
		if (bem == null)
			throw new NegocioException("Bem não pode ser nulo");
		var bemEntity = bemJpaRepository.save(bemMaquEquiMapper.toBemEntity(bem));
		return bemMaquEquiMapper.fromBemEntity(bemEntity);
	}
	
	@Override
	public MaquEqui incluir(MaquEqui maquEqui) {
		if (maquEqui == null)
			throw new NegocioException("Máquina e equipamento não pode ser nulo");
		var maquEquiEntity = maquEquiJpaRepository.save(bemMaquEquiMapper.toMaquEquiEntity(maquEqui));
		return bemMaquEquiMapper.fromMaquEquiEntity(maquEquiEntity);
	}

	@Override
	public Endereco incluir(Endereco endereco) {
		if (endereco == null)
			throw new NegocioException("Bem não pode ser nulo");
		var enderecoEntity = enderecoJpaRepository.save(bemMaquEquiMapper.toEnderecoEntity(endereco));
		return bemMaquEquiMapper.fromEnderecoEntity(enderecoEntity);
	}

	@Override
	public Seguro incluir(Seguro seguro) {
		if (seguro == null)
			throw new NegocioException("Bem não pode ser nulo");
		var seguroEntity = seguroJpaRepository.save(bemMaquEquiMapper.toSeguroEntity(seguro));
		return bemMaquEquiMapper.fromSeguroEntity(seguroEntity);
	}

	@Override
	public Bem atualizar(Bem bem) {
		return this.incluir(bem);
	}

	@Override
	public void deletar(String idBem) {
		var maquEquiPk = bemMaquEquiMapper.toEntityPk(idBem);
		{
			bemJpaRepository.deleteById(maquEquiPk);
		}
	}

	@Override
	public Optional<Bem> consultarPorId(String idBem) {
		var bemPk = bemMaquEquiMapper.toEntityPk(idBem);
		var bemEntityOptional = bemJpaRepository.findById(bemPk);
		if (bemEntityOptional.isEmpty()) {
			return Optional.empty();
		}
		var bem = bemMaquEquiMapper.fromBemEntity(bemEntityOptional.get());
		return Optional.of(bem);
	}

	@Override
	public Long verificarSeExiste(String idBem) {
		return bemJpaRepository.countByPk(bemMaquEquiMapper.toEntityPk(idBem));
	}
}