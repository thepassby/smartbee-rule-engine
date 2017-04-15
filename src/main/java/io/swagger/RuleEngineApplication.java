/**
 * 
 */
package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author reset
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io.swagger", "cc.nolink"})
@EnableSwagger2
public class RuleEngineApplication implements CommandLineRunner {

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RuleEngineApplication.class, args);
	}
}
