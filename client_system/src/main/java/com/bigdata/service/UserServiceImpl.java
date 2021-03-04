package com.bigdata.service;

import com.bigdata.jpa.data.User;
import com.bigdata.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigdata.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService{
  @Autowired
  UserRepo userRepo;
  public List<User> getList() {
    return null;
  }

  public void updateUser(int id) {

  }


  public void insertUser() {
    User user = new User();
    for(int i = 0; i < 50; i++){

      user.setName("zhangsan"+i);
      user.setAddress("bj" + i);
      //insert if key exits wrong
      // save  if key exits update
      User users = userRepo.insert(user);
      System.out.println(users.getId());
    }
  }

  public void removeUser(int id) {

  }
}
