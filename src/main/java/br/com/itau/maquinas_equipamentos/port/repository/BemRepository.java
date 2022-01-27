package br.com.itau.maquinas_equipamentos.port.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;

@Component
public interface BemRepository {

	Bem atualizar(Bem bem);

	void deletar(String idBem);

	Optional<Bem> consultarPorId(String idBem);

	Long verificarSeExiste(String idBem);

	Bem incluir(Bem bem, Endereco endereco);

	Object incluir(Bem bem, Bem endereco);
}
