package com.sibyl.application.controller;

import com.sibyl.application.mapper.UserMapper;
import com.sibyl.application.pojo.User;
import com.sibyl.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Classname ReactiveControllor
 * @Description TODO
 * @Date 2021/8/23 20:31
 * @Created by dyingleaf3213
 */
@RestController
@RequestMapping("/rt")
public class ReactiveControllor {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/get")
    public Flux<User> findAll(){
        return Flux.fromIterable(userService.getAllUser());
    }

    @PostMapping("/post")
    public Mono<ResponseEntity<?>> create(@Validated @RequestBody User user,
                                          BindingResult bindingResult,
                                          UriComponentsBuilder ucb)
        throws MethodArgumentNotValidException{
            Optional<User> theUser= Optional.ofNullable(userService.findById(user.getId()));
            if(theUser.isPresent()){
                bindingResult.rejectValue("name","already.exists","already exists");
            }
            if(bindingResult.hasErrors()){
                throw (new MethodArgumentNotValidException(
                        new MethodParameter(new Object(){}.getClass().getEnclosingMethod(),0),
                        bindingResult
                ));
            }
            userMapper.insert(user);
            return Mono.just(ResponseEntity.created(
                    ucb.path("/rt/post").path(user.getName()).build().toUri()
            ).build());
        }
}
