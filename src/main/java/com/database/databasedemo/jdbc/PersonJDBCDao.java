package com.database.databasedemo.jdbc;

import com.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJDBCDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
       return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));

    }

    public Object findByID(int id) {
        return jdbcTemplate.queryForObject("select * from person where id =? ",new Object[]{ id }, new BeanPropertyRowMapper(Person.class));

    }


    public Object findByLocation(String location) {
        return jdbcTemplate.queryForObject("select * from person where location =? ",new Object[]{ location }, new BeanPropertyRowMapper(Person.class));

    }

    public int deleteByID(int id) {
        return jdbcTemplate.update("delete  from person where id =? ",new Object[]{ id });
    }
}
