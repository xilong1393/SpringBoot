package com.example.demo.Service;

import com.example.demo.Dao.GroupsDao;
import com.example.demo.Model.Groups;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GroupService {
    @Autowired
    private GroupsDao groupsDao;

    public List<Groups> addGroup(Groups group){
        groupsDao.save(group);
        final List<Groups> groups = getGroups();
        return groups;
    }

    private List<Groups> getGroups() {
        List<Groups> groups=new ArrayList<>();
        groupsDao.findAll().forEach(groups::add);
        return groups;
    }
}
