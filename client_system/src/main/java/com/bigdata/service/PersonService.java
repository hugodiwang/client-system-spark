package com.bigdata.service;

import com.bigdata.jpa.data.Person;
import com.bigdata.jpa.data.User;

import java.util.List;
import java.util.Map;

public interface PersonService {
  //insert
  public void insert();
  //find one based on conditions
  public Person findOne();
  //find all based on conditions
  public List<Person> findAll();
  //update
  public void update();
  //delete
  public void remove();
  public List<Person> getPerson(int pageNumber, int pageSize);
}