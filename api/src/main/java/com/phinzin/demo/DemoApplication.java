package com.phinzin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/**
	 * @return EhCacheManagerFactoryBean
	 */
	@Bean
	public EhCacheManagerFactoryBean createEhCacheManagerFactory() {
		EhCacheManagerFactoryBean aEhCacheManagerFactoryBean =
				new EhCacheManagerFactoryBean();
		aEhCacheManagerFactoryBean.setShared(true);
		return aEhCacheManagerFactoryBean;
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("locale/messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
}
