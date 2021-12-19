package com.database.databasedemo;

import com.database.databasedemo.entity.Person;
import com.database.databasedemo.jdbc.PersonJDBCDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJDBCDao personJDBCDao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 logger.info("All users -> {}", personJDBCDao.findAll());
		logger.info("User id 10001 -> {}", personJDBCDao.findByID(10001));
		logger.info("User location Amsterdam -> {}", personJDBCDao.findByLocation("Amsterdam"));
		logger.info("deleting id 10002  -> No of rows deleted - {}", personJDBCDao.deleteByID(10002));

		logger.info("Insert 10004 => {}", personJDBCDao.insert(new Person(1004, "Tara", "Berlin", new Date())));

		logger.info("Update 10003 => {}", personJDBCDao.update(new Person(10003, "Peter", "London", new Date())));

	}
}
