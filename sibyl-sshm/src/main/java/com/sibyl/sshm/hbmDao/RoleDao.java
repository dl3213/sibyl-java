package com.sibyl.sshm.hbmDao;

import com.sibyl.sshm.entity.Role;

import java.util.List;

public interface RoleDao {
     public List<Role> findAll();
     public Role findBookById(int id);
     public void save(Role book);
     public void update(Role book);
     public void delete(int id);

     List<Object> query(String sql);
}
