package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemMaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.port.repository.BemMaquEquiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class DeletarBemMaquEqui {

	private BemMaquEquiRepository bemMaquEquiRepository;

	@Inject
	public DeletarBemMaquEqui(BemMaquEquiRepository bemMaquEquiRepository) {
		this.bemMaquEquiRepository = bemMaquEquiRepository;
	}

	public void execute(String idBem) {
		verificarSeExiste(idBem);
		log.info("Apagando_Maquina_Equipamento=idBem={}", idBem);
		bemMaquEquiRepository.deletar(idBem);
	}

	private void verificarSeExiste(String idBem) {
		var bemOptional = bemMaquEquiRepository.consultarPorId(idBem);
		if (bemOptional.isEmpty()) {
			log.info("Maquina_Equipamento_Nao_Encontrado=idBem{}", idBem);
			throw new BemMaquEquiNaoEncontradoException(idBem);
		}
	}
}