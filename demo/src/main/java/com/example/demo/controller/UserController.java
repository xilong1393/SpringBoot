package com.example.demo.controller;

import com.example.demo.Model.Users;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<Users> users(){
        return userService.getUsers();
    }

    @RequestMapping("/getByGroupsId/{groupsId}")
    public List<Users> users(@PathVariable String groupsId){
        return userService.getByGroupsId(groupsId);
    }

    @RequestMapping("/user/{id}")
    public Optional<Users> user(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/group/{groupsId}/users")
    public List<Users> addUser(@RequestBody Users user,@PathVariable String groupsId){
        return userService.addUser(user,groupsId);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/users/{id}")
    public List<Users> updateUser(@RequestBody Users user, @PathVariable String id){
        return userService.updateUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/users/{id}")
    public List<Users> deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
