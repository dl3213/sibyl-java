package com.sibyl.sshm.controller;

import com.sibyl.base.domain.R;
import com.sibyl.base.entity.User;
import com.sibyl.sshm.pojo.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname AppController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:58
 */
@Controller
@RequestMapping("/app")
public class AppController {

    /**
     *  文件上传
     */
    @RequestMapping(value = "/test22")
    @ResponseBody
    public R test22(String username, MultipartFile file) {
        return R.success();
    }

    @RequestMapping(value = "/test12")
    @ResponseBody
    public R test12(@CookieValue(value = "id") String cookie ) {
        return R.success();
    }

    @RequestMapping(value = "/test11")
    @ResponseBody
    public R test11(@RequestHeader(value = "token",required = false) String token ) {

        return R.success();
    }

    @RequestMapping(value = "/test10")
    //响应数据，非页面
    @ResponseBody
    public R test10(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        return R.success();
    }

    @RequestMapping(value = "/test9/{id}")
    //响应数据，非页面
    @ResponseBody
    public R test9(@PathVariable(value = "id",required = true) long id) {
        System.err.println(id);
        return R.success();
    }

    @RequestMapping(value = "/test8")
    //响应数据，非页面
    @ResponseBody
    public R test8(@RequestParam(value = "name",required = false,defaultValue = "username") String user) {
        System.err.println(user);
        return R.success();
    }

    @RequestMapping(value = "/test7")
    //响应数据，非页面
    @ResponseBody
    public R test7(@RequestBody List<User> vo) {
        System.err.println(vo);
        return R.success();
    }

    @RequestMapping(value = "/test6")
    //响应数据，非页面
    @ResponseBody
    public R test6(@RequestBody TestVo vo) {
        System.err.println(vo);
        return R.success();
    }

    @RequestMapping(value = "/test5")
    //响应数据，非页面
    @ResponseBody
    public R test5(String[] arr) {
        System.err.println(Arrays.asList(arr));
        return R.success();
    }

    @RequestMapping(value = "/test4")
    //响应数据，非页面
    @ResponseBody
    public R test4(User user) {
        System.err.println(user);
        return R.success();
    }

    @RequestMapping(value = "/test3")
    //响应数据，非页面
    @ResponseBody
    public R test3(String username,Integer id) {
        System.err.println(username);
        System.err.println(id);
        return R.success();
    }

    @RequestMapping(value = "/test2")
    //响应数据，非页面
    @ResponseBody
    public R test2() {
        return R.success();
    }

    @RequestMapping(value = "/test1")
    //响应数据，非页面
    @ResponseBody
    public String test1() {
        return "test1";
    }

    @RequestMapping(value = "/test")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().print("test");

    }

    @RequestMapping(value = "/save5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","dl3213");
        return "/app/save.jsp";
    }

    @RequestMapping(value = "/save4")
    public String save4(Model model){
        model.addAttribute("username","dl3213");
        return "/app/save.jsp";
    }

    @RequestMapping(value = "/save3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.setViewName("/app/save.jsp");
        modelAndView.addObject("username","dl3213");
        return modelAndView;
    }

    @RequestMapping(value = "/save2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/app/save.jsp");
        modelAndView.addObject("username","dl3213");
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.err.println("controller save");
        return "/app/save.jsp";
    }
}
