package com.newberry;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class BookApplication extends SpringBootServletInitializer implements EnvironmentAware {

	/**
	 * Entry point for Spring Boot application.
	 *
	 * @param args - list of arguments to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	/**
	 *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BookApplication.class);

	/**
	 * Log out profile information so we know what is booting up.
	 *
	 * @param environment Used to get active profiles.
	 */
	@Override
	public void setEnvironment(Environment environment) {
		LOGGER.info("Active Spring profiles: ", Joiner.on(' ').join(environment.getActiveProfiles()));
	}

	/**
	 * This is Spring Boot's hook to run this stuff as a war file in Tomcat (not
	 * as a executable jar file). This means developers can still run this app
	 * using the main method, but it will also be runnable via Tomcat.
	 *
	 * @param application Spring things
	 * @return more Spring things
	 */
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(BookApplication.class);
	}
}
