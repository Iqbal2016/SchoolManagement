package com.iqbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SchoolManagementApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}
	
	/*
	 * @Configuration public class DefaultView extends WebMvcConfigurerAdapter{
	 * 
	 * @Override public void addViewControllers( ViewControllerRegistry registry ) {
	 * registry.addViewController( "/" ).setViewName( "forward:/sb-admin/index.html"
	 * ); registry.setOrder( Ordered.HIGHEST_PRECEDENCE ); super.addViewControllers(
	 * registry ); } }
	 */

}
