package com.sibyl.application.service.fun;

import com.sibyl.application.pojo.User;
import com.sibyl.application.service.UserService;

import javax.annotation.Resource;
import java.util.function.Supplier;

/**
 * @Classname SupplierMain
 * @Description 生产者
 * @Author dyingleaf3213
 * @Create 2021/11/07 17:28
 */

public class SupplierMain {

    public static void main(String[] args) {
        User user = getUser(() -> new User());
        System.err.println(user);

        int[] arr =  {1,2,3,4,5};
        getInt(()->arr[0]);
    }

    public static Integer getInt(Supplier<Integer> supplier){
        return supplier.get();
    }


    public static User getUser(Supplier<User> supplier){
        return supplier.get();
    }
}
