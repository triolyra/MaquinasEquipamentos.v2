package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.BemJpaRepository;
import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.EnderecoJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.BemRepository;

@Repository
public class BemRepositoryImpl implements BemRepository {

	@Autowired
	private BemJpaRepository bemJpaRepository;
	
	@Autowired
	private EnderecoJpaRepository enderecoJpaRepository;

	private final BemMapper bemMapper = MapperFactory.newInstance(BemMapper.class);

	@Override
	public Bem incluir(Bem bem, Endereco endereco) {
		if (bem == null && endereco == null) 
			throw new NegocioException("O bem não pode ser nulo");
		var bemEntity = bemJpaRepository.save(bemMapper.toBemEntity(bem));
		var enderecoEntity = enderecoJpaRepository.save(bemMapper.toEnderecoEntity(endereco));
		return bemMapper.fromBemEntity(bemEntity, enderecoEntity);
	}

	@Override
	public Bem atualizar(Bem bem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(String idBem) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Bem> consultarPorId(String idBem) {
		var bemPk = bemMapper.toEntityPk(idBem);
		var bemEntityOptional = bemJpaRepository.findById(bemPk);
		if (bemEntityOptional.isEmpty()) {
			return Optional.empty();
		}
		var bem = bemMapper.fromBemEntity(bemEntityOptional.get(), null);
		return Optional.of(bem);
	}

	@Override
	public Long verificarSeExiste(String idBem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object incluir(Bem bem, Bem endereco) {
		// TODO Auto-generated method stub
		return null;
	}
}
