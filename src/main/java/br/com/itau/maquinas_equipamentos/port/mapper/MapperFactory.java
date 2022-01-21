package br.com.itau.maquinas_equipamentos.port.mapper;

import org.mapstruct.factory.Mappers;

public class MapperFactory {

	private MapperFactory() {
	}
	
	public static <T> T newInstance(final Class <T> clazz){
		return Mappers.getMapper(clazz);
	}
}
