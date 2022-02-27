package com.sibyl.sshm;

import com.sibyl.sshm.config.SpringConfiguration;
import com.sibyl.sshm.service.RoleService;
import com.sibyl.sshm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Classname SpringTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringTest {

    @Resource
    private RoleService roleService;
    @Resource
    private DataSource dataSource;

    @Test
    public void test5() {
        roleService.saveRole();
        System.err.println(dataSource);
    }

    @Test
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.err.println(connection);
        connection.close();
    }

    @Test
    public void test3(){
//        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
//        String driver = rb.getString("jdbc.driver");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriver();
    }

    @Test
    public void test2(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        DruidPooledConnection connection = druidDataSource.getConnection();
    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
