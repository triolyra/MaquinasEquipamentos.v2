package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.EnderecoJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;
import br.com.itau.maquinas_equipamentos.port.mapper.BemMapper;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.repository.EnderecoRepository;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

	@Autowired
	private EnderecoJpaRepository enderecoJpaRepository;
	
	private final BemMapper bemMapper = MapperFactory.newInstance(BemMapper.class);
	
	@Override
	public Endereco incluir(Endereco endereco) {
		if (endereco == null)
			throw new NegocioException("O endereço não pode ser nulo");
		var enderecoEntity = enderecoJpaRepository.save(bemMapper.toEnderecoEntity(endereco));
		return bemMapper.fromEnderecoEntity(enderecoEntity);
	}

	@Override
	public Endereco atualizar(Endereco endereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(String idBem, int idTipoBem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Endereco> consultarPorId(String idBem, int idTipoBem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long verificarSeExiste(String idBem, int idTipoBem) {
		// TODO Auto-generated method stub
		return null;
	}

}
