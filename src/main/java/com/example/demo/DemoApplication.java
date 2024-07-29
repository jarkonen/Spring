package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.conexion.Crud_clientes;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }
    
    @Bean
    public ServletRegistrationBean<AnotherServlet> anotherServletRegistrationBean() {
        return new ServletRegistrationBean<>(new AnotherServlet(), "/anotherServlet");
    }
    
    @PostConstruct
    public void init() {
        //Crud_clientes.introduce_cliente("patata2", "patata2");
        Crud_clientes.leer_clientes();
        Crud_clientes.actualizar_cliente("Gallina", "gallina");
    }

}
