package com.example.demo.Service;

import com.example.demo.Dao.GroupsDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.Model.Groups;
import com.example.demo.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupsDao groupsDao;

    private List<Users> users= new ArrayList<>(Arrays.asList(
            new Users("1","Sam"),
            new Users("2","Luke"),
            new Users("3","Michael")
    ));
    public List<Users> getUsers() {
        // return users;
        List<Users> users=new ArrayList<>();
        userDao.findAll().forEach(users::add);
        return users;
    }

    public List<Users> getByGroupsId(String groupsId) {
        // return users;
        List<Users> users=new ArrayList<>();
        userDao.findByGroupsId(groupsId).forEach(users::add);
        return users;
    }

    public Optional<Users> getUser(String id){
        //return users.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return userDao.findById(id);
    }
    @Transactional
    public List<Users> addUser(Users user, String groupsId){
        Groups groups=new Groups(groupsId,"");
        user.setGroups(groups);
        groupsDao.save(groups);
        try
        {
            int num=1/0;
        }
        catch (Exception ex){
            //throw ex;
        }
        userDao.save(user);
        final List<Users> users = getUsers();
        return users;
    }

    public List<Users> updateUser(Users user){
//        for (int i=0;i<users.size();i++){
//            Users u=users.get(i);
//            if(u.getId().equals(user.getId())){
//                users.set(i,user);
//                break;
//            }
//        }
//        return users;
        userDao.save(user);
        final List<Users> users = getUsers();
        return users;
    }

    public List<Users> deleteUser(String id){
//        users.removeIf(t->t.getId().equals(id));
//        return users;
        userDao.deleteById(id);
        final List<Users> users = getUsers();
        return users;
    }
}
