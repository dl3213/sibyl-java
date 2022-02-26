package com.sibyl.ca.service;

import com.sibyl.base.domain.R;
import com.sibyl.base.entity.User;

public interface UserLoginService {

    R login(User user);
    R logout();
}
