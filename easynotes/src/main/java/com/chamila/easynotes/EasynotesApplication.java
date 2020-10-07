package com.chamila.easynotes;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.chamila.easynotes.controller.NoteController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan
@EnableAutoConfiguration /*
							 * @SpringBootApplication can be used once in place
							 * of @Configuration, @ComponentScan and @EnableAutoConfiguration
							 */

@EnableJpaAuditing
@Import(NoteController.class) /*
								 * If not imported, the API calls will give a 404 error, since the relevant HTTP
								 * methods are declared in this class
								 */
@EnableSwagger2
public class EasynotesApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EasynotesApplication.class);
		
		 
		
app.run(EasynotesApplication.class);// The spring container gets
															// started(ConfigurableApplicationContext) once this is
															// called.

		/*
		 * Once the spring container gets started, it is responsible for: 1. Creating
		 * all objects: This is done by component
		 * scan- @SpringBootApplication(combination of @Configuration
		 * + @ComponentScan+ @EnableAutoConfiguration) 2. Dependency Injection. 3.
		 * Managing the life cycle of all beans.
		 */
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build();
	}

}
