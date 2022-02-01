package br.com.itau.maquinas_equipamentos.domain.exception;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;

public class BemMaquEquiNaoEncontradoException extends NegocioException {

	private static final long serialVersionUID = 3029128520249095094L;

	public BemMaquEquiNaoEncontradoException(String idBem) {
		super(new BemMaquEntityPK().toString());
	}
}
