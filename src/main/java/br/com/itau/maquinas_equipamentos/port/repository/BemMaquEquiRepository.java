package br.com.itau.maquinas_equipamentos.port.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.domain.model.Endereco;
import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;
import br.com.itau.maquinas_equipamentos.domain.model.Seguro;

@Component
public interface BemMaquEquiRepository {

	Bem incluir(Bem bem);
	MaquEqui incluir(MaquEqui maquEqui);
	Endereco incluir(Endereco endereco);
	Seguro incluir(Seguro seguro);
	
	Bem atualizar(Bem bem);

	void deletar(String idBem);

	Optional<Bem> consultarPorId(String idBem);

	Long verificarSeExiste(String idBem);
}