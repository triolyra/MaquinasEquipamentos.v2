package br.com.itau.maquinas_equipamentos.adapter.http.controller;

import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.maquinas_equipamentos.domain.exception.BemMaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.usecase.AtualizarBemMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.BuscarBemMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.DeletarBemMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.IncluirBemMaquEqui;
import br.com.itau.maquinas_equipamentos.port.dto.BemDto;
import br.com.itau.maquinas_equipamentos.port.dto.EnderecoDto;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.dto.SeguroDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/garantias")
@RequiredArgsConstructor
public class BemMaquEquiController {

	private final IncluirBemMaquEqui incluirBemMaquEqui;
	private final BuscarBemMaquEqui buscarBemMaquEqui;
	private final DeletarBemMaquEqui deletarBemMaquEqui;
	private final AtualizarBemMaquEqui atualizarBemMaquEqui;
	public static final String PATH_MAQUEQUI = "bens/{id_bem}/maquinas-equipamentos";
	public static final String ID_BEM = "id_bem";
	public static final String ID_TIPO_BEM = "id_tipo_bem";

	@PostMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<BemDto> incluirBem(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody BemDto bemDto) {
		bemDto.setIdBem(idBem.toString());
		var bem = incluirBemMaquEqui.execute(bemDto);
		log.info("Bem_Salvo={}", bem.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(incluirBemMaquEqui.execute(bem));
	}

	@PostMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<MaquEquiDto> incluirMaquEqui(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody MaquEquiDto maquEquiDto) {
		maquEquiDto.setIdBem(idBem.toString());
		var maquEqui = incluirBemMaquEqui.execute(maquEquiDto);
		log.info("MaquEqui_Salvo={}", maquEqui.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(incluirBemMaquEqui.execute(maquEqui));
	}
	
	@PostMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<EnderecoDto> incluirEndereco(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody EnderecoDto enderecoDto) {
		enderecoDto.setIdBem(idBem.toString());
		var endereco = incluirBemMaquEqui.execute(enderecoDto);
		log.info("Endereco_Salvo={}", endereco.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(incluirBemMaquEqui.execute(endereco));
	}
	
	@PostMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<SeguroDto> incluirSeguro(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody SeguroDto seguroDto) {
		seguroDto.setIdBem(idBem.toString());
		var seguro = incluirBemMaquEqui.execute(seguroDto);
		log.info("Seguro_Salvo={}", seguro.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(incluirBemMaquEqui.execute(seguro));
	}
	
	@GetMapping(PATH_MAQUEQUI)
	public ResponseEntity<BemDto> buscarPorId(@PathVariable(name = ID_BEM) UUID idBem) throws NegocioException {
		BemDto bemDto;
		try {
			bemDto = buscarBemMaquEqui.execute(idBem.toString());
			log.info("MaquEqui_Retornado={}", bemDto.toString());
		} catch (BemMaquEquiNaoEncontradoException ex) {
			throw new NegocioException("N??o foi encontrado");
		}
		return ResponseEntity.ok(buscarBemMaquEqui.execute(bemDto));
	}

	@PatchMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<BemDto> atualizarBem(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody BemDto bemDto) throws NegocioException {
		bemDto.setIdBem(idBem.toString());
		BemDto maquEquiAtualizado;
		try {
			maquEquiAtualizado = atualizarBemMaquEqui.execute(bemDto);
		} catch (BemMaquEquiNaoEncontradoException ex) {
			throw new NegocioException("N??o foi encontrado");
		}
		log.info("Maquina_Equipamento_Atualizado={}", maquEquiAtualizado.toString());
		return ResponseEntity.ok(atualizarBemMaquEqui.execute(bemDto));
	}

	@DeleteMapping(PATH_MAQUEQUI)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarBem(@PathVariable(name = ID_BEM) UUID idBem) throws NegocioException {
		try {
			deletarBemMaquEqui.execute(idBem.toString());
		} catch (BemMaquEquiNaoEncontradoException ex) {
			throw new NegocioException("N??o foi encontrado");
		}
	}
}