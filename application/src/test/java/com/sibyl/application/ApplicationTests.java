package com.sibyl.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.ColumnCache;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sibyl.Application;
import com.sibyl.application.base.CommonBeanUtils;
import com.sibyl.application.entity.WarnRecord;
import com.sibyl.application.mapper.UserMapper;
import com.sibyl.application.entity.User;
import com.sibyl.application.mapper.WarnRecordMapper;
import com.sibyl.application.service.iml.UserServiceImp;
import com.sibyl.application.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Application.class)
@Slf4j
class ApplicationTests {

    @Autowired
    private WarnRecordMapper warnRecordMapper;

    @Test
    public void warnTest(){
        QueryWrapper<WarnRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(WarnRecord::getId,1479078169913872386L,1479078173399339009L);
        List<WarnRecord> warnRecords = warnRecordMapper.selectList(queryWrapper);
        System.err.println(warnRecords);
//        for (int i = 0; i < 10; i++) {
//            WarnRecord record = new WarnRecord();
//            record.setUid("dl3123");
//            record.setPsychoPass((int) (Math.random()*100 +1));
//            record.setCreateTime(LocalDateTime.now());
//            warnRecordMapper.insert(record);
//        }
    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImp userServiceImp;

    @Test
    public void serializedLambda() throws Exception {
        SerializedLambda serializedLambda = doSFunction(User::getName);
        System.out.println("方法名：" + serializedLambda.getImplMethodName());
        System.out.println("类名：" + serializedLambda.getImplClass());
        System.err.println(serializedLambda);
    }

    private static <T, R> java.lang.invoke.SerializedLambda doSFunction(MFunction<T, R> func) throws Exception {
        // 直接调用writeReplace
        Method writeReplace = func.getClass().getDeclaredMethod("writeReplace");
        writeReplace.setAccessible(true);
        //反射调用
        Object sl = writeReplace.invoke(func);
        java.lang.invoke.SerializedLambda serializedLambda = (java.lang.invoke.SerializedLambda) sl;
        return serializedLambda;
    }


    @Test
    public void funTest(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName,"dl3213");
        Map<String, ColumnCache> columnMap = LambdaUtils.getColumnMap(User.class);
        columnMap.forEach((s, columnCache) -> System.err.println(s+"=="+columnCache));

        Function<User, String> getName = User::getName;
        System.err.println(getName.getClass());
        System.err.println(getName.toString());

//        List<User> allUser = userServiceImp.getAllUser();
//        User user = allUser.stream().max(Comparator.comparing(User::getAge)).get();
//        System.err.println(user);
    }

    @Test
    public void sqlTest(){
        List<UserVo> userVoList = new ArrayList<>();

        Page<User> users = userServiceImp.getPageOfUser();
        users.getRecords().forEach(item ->{
            System.err.println(item.getName());
        });
        final List<UserVo> userVos =
                CommonBeanUtils.copyListProperties(users.getRecords(), UserVo.class);
        System.err.println("");
    }

    @Test
    void contextLoads() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}
@FunctionalInterface
interface MFunction<T, R> extends Function<T, R>, Serializable {
}
