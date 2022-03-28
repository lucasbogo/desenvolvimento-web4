
package br.com.cineclube.config.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import br.com.cineclube.model.Category;

// Tentando retornar lista de filmes por categoria; NOT MINE.
@Service
public class GenderStringToEnumConverter implements Converter<String, Category> {

	public Category convert(String source) {
		try {
			return Category.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}

	}
}