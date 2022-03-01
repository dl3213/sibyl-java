package com.sibyl.sshm.service;

import com.sibyl.sshm.entity.Role;

public interface RoleService {
    Role findById(int id);

    void save(Role role);
}
