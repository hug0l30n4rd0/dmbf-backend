package com.dmbf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dmbf.persistence.BaseRepositoryImpl;
@SpringBootApplication
//@EnableDiscoveryClient(autoRegister=true)
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableFeignClients(basePackages = {"br.gov.inss.unidadeGestora"})
////@RibbonClient(name=EntidadesFederativasUtil.APPLICATION_REQUIRED_NAME, configuration = RibbonConfiguration.class)
@EntityScan
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class DMBFApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DMBFApplication.class, args);
	}
}

