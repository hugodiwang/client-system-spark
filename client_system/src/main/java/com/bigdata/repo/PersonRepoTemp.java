package com.bigdata.repo;

import com.bigdata.jpa.data.Person;

import java.util.List;
import java.util.Map;

public interface PersonRepoTemp {
  //insert
  public void insert(Person object);
  //find one based on conditions
  public Person findOne(Map<String, Object> params);
  //find all based on conditions
  public List<Person> findAll(Map<String, Object> params);
  //update
  public void update(Map<String, Object> params);
  //delete
  public void remove(Map<String, Object> params);

  //page querying
  public List<Person> getPerson(int pageNumber, int pageSize);
}
