package br.com.cineclube.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.cineclube.conversor.GenderStringToEnumConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new GenderStringToEnumConverter());
	}
}