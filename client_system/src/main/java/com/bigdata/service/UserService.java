package com.bigdata.service;

import com.bigdata.jpa.data.User;

import java.util.List;

public interface UserService {
  // select/remove/insert
  public List<User> getList();
  public void updateUser(int id);
  public void insertUser();
  public void removeUser(int id);
}
