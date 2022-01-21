package br.com.itau.maquinas_equipamentos.domain.exception;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.BemMaquEntityPK;

@SuppressWarnings("serial")
public class BemNaoEncontradoException extends NegocioException {
	
	public BemNaoEncontradoException(String idBem) {
		super (new BemMaquEntityPK(idBem).toString());
	}
}
