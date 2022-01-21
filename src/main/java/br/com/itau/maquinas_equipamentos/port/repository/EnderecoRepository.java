package br.com.itau.maquinas_equipamentos.port.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.itau.maquinas_equipamentos.domain.model.Endereco;

@Component
public interface EnderecoRepository {

	Endereco incluir(Endereco endereco);

	Endereco atualizar(Endereco endereco);

	void deletar(String idBem, int idTipoBem);

	Optional<Endereco> consultarPorId(String idBem, int idTipoBem);

	Long verificarSeExiste(String idBem, int idTipoBem);
}
