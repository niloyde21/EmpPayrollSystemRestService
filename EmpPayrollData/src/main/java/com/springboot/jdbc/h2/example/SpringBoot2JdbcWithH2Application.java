package com.springboot.jdbc.h2.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jdbc.h2.example.employeePayroll.Employee;
import com.springboot.jdbc.h2.example.employeePayroll.EmployeeJdbcRepository;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Employee id 1 -> {}", repository.findById(1));

//		logger.info("Inserting -> {}", repository.insert(new Employee(10010L, "John", "A1234657")));
//
//		logger.info("Update 10003 -> {}", repository.update(new Employee(10001L, "Name-Updated", "New-Passport")));
//
//		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}
}
