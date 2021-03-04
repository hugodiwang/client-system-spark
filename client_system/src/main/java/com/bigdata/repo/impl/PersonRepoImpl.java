package com.bigdata.repo.impl;

import com.bigdata.api.MongoDataPageable;
import com.bigdata.jpa.data.Person;
import com.bigdata.repo.PersonRepoTemp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

// implements select/drop/insert with mongotemplate in mongodb-context.xml
public class PersonRepoImpl implements PersonRepoTemp {
  @Resource
  private MongoTemplate mongoTemplate;
  public void insert(Person object) {
    mongoTemplate.insert(object);
  }

  public Person findOne(Map<String, Object> params) {
    Query query = new Query(Criteria.where("name").is(params.get("name")));
    Person person = mongoTemplate.findOne(query, Person.class);
    return person;

  }

  public List<Person> findAll(Map<String, Object> params) {
    List<Person> persons = mongoTemplate.find(new Query(Criteria.where("age").lt(params.get("age"))), Person.class);
    return persons;
    //lt means <
    // if data is in large scale, we do paging query
  }

  public void update(Map<String, Object> params) {
    mongoTemplate.upsert(new Query(Criteria.where("name").is(params.get("name"))), new Update().set("address", params.get("address")), Person.class);


  }

  public void remove(Map<String, Object> params) {
    mongoTemplate.remove(new Query(Criteria.where("name").is(params.get("name"))), Person.class);
  }

  public List<Person> getPerson(int pageNumber, int pageSize){
    Page<Person> pageList = null;
    try{
      Query query = new Query();
      MongoDataPageable pageable = new MongoDataPageable();
      pageable.setPagenumber(pageNumber);
      pageable.setPagesize(pageSize);
      Long count = mongoTemplate.count(query, Person.class);
      List<Person> list = mongoTemplate.find(query.with(pageable), Person.class);
      pageList=new PageImpl<Person>(list, pageable, count);

    }catch(Exception e){
      e.printStackTrace();

    }
    return pageList.getContent();
  }
}
