package br.com.itau.maquinas_equipamentos.adapter.http.controller;

import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.maquinas_equipamentos.domain.exception.BemNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.usecase.BuscarBemMaqu;
import br.com.itau.maquinas_equipamentos.domain.usecase.DeletarBemMaqu;
import br.com.itau.maquinas_equipamentos.domain.usecase.IncluirBemMaqu;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/garantias")
@RequiredArgsConstructor
public class MaquEquiController {

	private final IncluirBemMaqu incluirBemMaqu;
	private final BuscarBemMaqu buscarBemMaqu;
	private final DeletarBemMaqu deletarBemMaqu;
	public static final String PATH_MAQUEQUI = "bens/{id_bem}/maquinas-equipamentos";
	public static final String ID_BEM = "id_bem";
	public static final String ID_TIPO_BEM = "id_tipo_bem";

	@PostMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<BemDto> incluirBem(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody BemDto bemDto) {
		bemDto.setIdBem(idBem.toString());
		var bem = incluirBemMaqu.execute(bemDto);
		log.info("MaquEqu_Salvo={}", bem.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(incluirBemMaqu.execute(bem));
	}

	@GetMapping(PATH_MAQUEQUI)
	public ResponseEntity<BemDto> buscarPorId(@PathVariable(name = ID_BEM) UUID idBem) throws NegocioException {
		BemDto bemDto;
		try {
			bemDto = buscarBemMaqu.execute(idBem.toString());
			log.info("MaquEqui_Retornado={}", bemDto.toString());
		} catch (BemNaoEncontradoException ex) {
			throw new NegocioException("Não foi encontrado");
		}
		return ResponseEntity.ok(buscarBemMaqu.execute(bemDto));
	}

	@DeleteMapping(PATH_MAQUEQUI)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarBem(@PathVariable(name = ID_BEM) UUID idBem) throws NegocioException {
		try {
			deletarBemMaqu.execute(idBem.toString());
		} catch (BemNaoEncontradoException ex) {
			throw new NegocioException("Não foi encontrado");
	}
}
}
