package com.valtech.training.loanserviceclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanserviceclient.webservices.LoanServiceWS;

@Configuration
public class LoanServiceClientConfig {
	
	@Bean
	public LoanServiceWS createMovieService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.jaws.training.valtech.com/","LoanServiceImplBean"));
		proxy.setAddress("http://localhost:8080/services/loanService");
		return proxy.create(LoanServiceWS.class);
	}
	

}
