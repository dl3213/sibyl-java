package com.sibyl.sshm;

import com.sibyl.sshm.entity.Role;
import com.sibyl.sshm.hbmDao.RoleDao;
import com.sibyl.sshm.service.RoleService;
import com.sibyl.sshm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Classname SpringTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:21
 */

@RunWith(SpringJUnit4ClassRunner.class)  //进行测试要使用的工具
@ContextConfiguration("classpath:spring-core.xml") //指定配置所在位置
public class SpringTest {

    @Resource
    private UserService userService;
    @Resource
    private RoleDao roleDao;
    @Resource
    private RoleService roleService;
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Test
    public void test7() throws IOException {
        System.err.println(roleDao.findAll());

        System.err.println(hibernateTemplate);

        System.err.println(hibernateTemplate.loadAll(Role.class));
    }

    @Test
    public void test6() throws IOException {
        System.err.println(userService.selectById(3210));
        System.err.println(userService.selectById(3213));


    }

}
