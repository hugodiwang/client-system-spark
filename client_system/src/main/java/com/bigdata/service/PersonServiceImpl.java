package com.bigdata.service;

import com.bigdata.api.MongoDataPageable;
import com.bigdata.jpa.data.Person;
import com.bigdata.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Service("personService")
public class PersonServiceImpl implements PersonService{
  @Autowired
  PersonRepo personRepo;
  public void insert() {
    Person person = new Person();
    for(int i = 0; i < 5; i++){
      person.setId(i);
      person.setAge(20 + i);
      person.setName("lisi" + i);
      person.setAddress("na" + i);
      personRepo.insert(person);
    }
  }

  public Person findOne() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", "lisi4");
    return personRepo.findOne(map);
  }

  public List<Person> findAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("age", 30);
    return personRepo.findAll(map);
  }

  public void update() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name","lisi5");
    map.put("address","i do not know");
    personRepo.update(map);


  }

  public void remove() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", "lisi1");
    personRepo.remove(map);

  }
  public List<Person> getPerson(int pageNumber, int pageSize){
    return personRepo.getPerson(pageNumber,pageSize);
  }


}
