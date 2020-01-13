package com.dmbf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dmbf.persistence.BaseRepositoryImpl;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
//public class DMBFApplication {
//	
//	public static void main(String[] args) {
//		SpringApplication.run(DMBFApplication.class, args);
//	}
//	
//	@Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

public class DMBFApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DMBFApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DMBFApplication.class);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
