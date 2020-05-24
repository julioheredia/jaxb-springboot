package br.com.heredia.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;

@EnableAutoConfiguration
@SpringBootApplication
@ImportResource(locations = "jaxwsconfig.xml")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean<WSSpringServlet> servletRegistrationBean() {
		return new ServletRegistrationBean<WSSpringServlet>(new WSSpringServlet(), "/MusicianService", "/BandService");
	}

}