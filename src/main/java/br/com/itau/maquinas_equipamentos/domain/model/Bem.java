package br.com.itau.maquinas_equipamentos.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Bem {

	public Bem(String idBem, int idTipoBem, String idUsuarioResponsavel, LocalDate dataDoCadastro,
			LocalDate dataDaAlteracao, char indicadorValorizacaoManual, double valorAtualDoBem) {
		if (!this.validaUUIDs(idBem))
			throw new NegocioException("Id bem inválido");
		this.idBem = idBem;
		this.idTipoBem = idTipoBem;
		this.idUsuarioResponsavel = idUsuarioResponsavel;
		this.dataDoCadastro = dataDoCadastro;
		this.dataDaAlteracao = dataDaAlteracao;
		this.indicadorValorizacaoManual = indicadorValorizacaoManual;
		this.valorAtualDoBem = valorAtualDoBem;
	}

	private int idTipoBem;
	private String idBem;

	private LocalDate dataDoCadastro;
	private LocalDate dataDaAlteracao;
	private String idUsuarioResponsavel;
	private char indicadorValorizacaoManual;
	private double valorAtualDoBem;

	private boolean validaUUIDs(String uuid) {
		try {
			UUID.fromString(uuid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}