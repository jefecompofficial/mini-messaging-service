package org.jefecomp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages ={"org.jefecomp.*"})
public class MiniMessagingServiceApplication {
	
    	public static void main(String[] args) {
    	    
	    SpringApplication.run(MiniMessagingServiceApplication.class, args);
	}
}