package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.Users;

import java.util.List;

public interface UserDao extends CrudRepository<Users, String>{
    List<Users> findByGroupsId(String groupsId);
}
