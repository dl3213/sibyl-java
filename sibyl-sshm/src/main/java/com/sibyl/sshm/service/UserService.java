package com.sibyl.sshm.service;


import com.sibyl.sshm.entity.User;

public interface UserService {
    User selectById(int id);
}
