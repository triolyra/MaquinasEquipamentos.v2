package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.BemJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemMaquEquiRepository;

@Repository
public class BemMaquEquiRepositoryImpl implements BemMaquEquiRepository {

	@Autowired
	private BemJpaRepository bemJpaRepository;

	private final BemMaquEquiMapper bemMaquEquiMapper = MapperFactory.newInstance(BemMaquEquiMapper.class);

	@Override
	public Bem incluir(Bem bem) {
		if (bem == null)
			throw new NegocioException("O bem não pode ser nulo");
		var bemEntity = bemJpaRepository.save(bemMaquEquiMapper.toBemEntity(bem));
		return bemMaquEquiMapper.fromBemEntity(bemEntity);
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