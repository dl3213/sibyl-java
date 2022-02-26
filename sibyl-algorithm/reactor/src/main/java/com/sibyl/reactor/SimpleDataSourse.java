package com.sibyl.reactor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SimpleDataSourse
 * @Description TODO
 * @Date 2021/8/22 19:38
 * @Created by dyingleaf3213
 */
public class SimpleDataSourse {
    public static User[] allUser(){
        List<User> users = new ArrayList<>();
        users.add(new User().setId(1L).setName("Jone").setAge(18).setEmail("test1@baomidou.com").setBelongs2(10));
        users.add(new User().setId(2L).setName("Jack").setAge(20).setEmail("test2@baomidou.com").setBelongs2(11));
        users.add(new User().setId(3L).setName("Tom").setAge(28).setEmail("test3@baomidou.com").setBelongs2(11));
        users.add(new User().setId(4L).setName("Sandy").setAge(21).setEmail("test4@baomidou.com").setBelongs2(11));
        users.add(new User().setId(5L).setName("Billie").setAge(24).setEmail("test5@baomidou.com").setBelongs2(10));
        return (User[]) users.toArray(new User[users.size()]);
    }
}
