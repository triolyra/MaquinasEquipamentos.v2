package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.port.repository.BemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class DeletarBemMaqu {

	private BemRepository bemRepository;

	@Inject
	public DeletarBemMaqu(BemRepository bemRepository) {
		this.bemRepository = bemRepository;
	}

	public void execute(String idBem) {
		verificarSeExiste(idBem);
		log.info("Apagando_Maquina_Equipamento=idBem={}", idBem);
		bemRepository.deletar(idBem);
	}

	private void verificarSeExiste(String idBem) {
		var bemOptional = bemRepository.consultarPorId(idBem);
		if (bemOptional.isEmpty()) {
			log.info("Maquina_Equipamento_Nao_Encontrado=idBem{}", idBem);
			throw new BemNaoEncontradoException(idBem);
		}
	}
}
