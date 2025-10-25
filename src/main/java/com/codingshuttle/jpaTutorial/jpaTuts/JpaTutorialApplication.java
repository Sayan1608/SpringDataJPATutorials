package com.codingshuttle.jpaTutorial.jpaTuts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTutorialApplication implements CommandLineRunner {

	@Value("${my.variable}")
	private String myVariable;
	public static void main(String[] args) {
		SpringApplication.run(JpaTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(myVariable);
	}


}
