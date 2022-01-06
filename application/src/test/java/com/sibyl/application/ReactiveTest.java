//package com.sibyl.application;
//
//import com.sibyl.Application;
//import com.sibyl.application.mapper.UserMapper;
//import com.sibyl.application.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import java.time.Duration;
//
///**
// * @Classname ReactiveTest
// * @Description TODO
// * @Date 2021/9/2 22:00
// * @Auther by dyingleaf3213
// */
//@SpringBootTest(classes = Application.class)
//@AutoConfigureWebTestClient
//public class ReactiveTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void test03(){
//        User user = User.builder().id(11234L).name("name").age(12).email("@test.com").build();
//
//        Mono<User> then = Mono.just(userMapper.insert(user)).then(Mono.just(userMapper.selectById(11234L)));
//
//        StepVerifier.create(then)
//                .expectNext(user)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    public void test02(){
//        StepVerifier.withVirtualTime(()->
//            Flux.just(1,2,3).delayElements(Duration.ofSeconds(3L)))
//                .expectSubscription()
//                .expectNoEvent(Duration.ofSeconds(3L))
//                .expectNext(1)
//                .expectNoEvent(Duration.ofSeconds(3L))
//                .expectNext(2)
//                .expectNoEvent(Duration.ofSeconds(3L))
//                .expectNext(3)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    public void test01(){
//        var flux = Flux.just(1,2,3);
//        StepVerifier.create(flux)
//                .expectNext(1)
//                .expectNext(2)
//                .expectNext(3)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    public void mainTest(){
//        String[] strs = {"1","2","3"};
//        Flux.fromArray(strs).map(s->Integer.parseInt(s))
//                .subscribe();
//    }
//}
