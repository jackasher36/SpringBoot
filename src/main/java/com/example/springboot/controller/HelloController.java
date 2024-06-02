package com.example.springboot.controller;

import com.example.springboot.pojo.MyDataSource;
import com.example.springboot.pojo.Review;
import com.example.springboot.pojo.Reviews;
import com.example.springboot.pojo.User;
import com.example.springboot.service.ReviewService;
import com.example.springboot.service.StudentService;
import com.example.springboot.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerTypePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className HelloController
 * @since 1.0
 **/
@Controller
public class HelloController {
    @Resource
    private StudentService studentService;

    @Autowired
    private MyDataSource myDataSource;
    @RequestMapping("/user")
    @ResponseBody
    public String hello(){
        System.out.println(myDataSource);
        return "欢迎使用springboot的,距离成功只有一步了!!!!!!!!!!!!!!!!!!!!!!" + myDataSource;
    }
    @RequestMapping("/test")
    @ResponseBody
    public String index(String id){
        User user = studentService.queryStudent(id);
        return user.toString();
    }
//    @GetMapping("/user/${uid}")
//    @ResponseBody
//    public String index2(@PathVariable("uid") String id){
//        User user = studentService.queryStudent(id);
//        return user.toString();
//    }
    @RequestMapping("/user/{uid}")
    @ResponseBody
    public String RESTFul(@PathVariable("uid") String id){
        User user = studentService.queryStudent(id);
        return user.toString();
    }
    @RequestMapping("/a")
    public String userTest(Model model){
        ArrayList<Object> users = new ArrayList<>();
        User user = new User("11", "23", 111);
        User user2 = new User("111", "2354", 11);
        User user3 = new User("113", "232", 21);
        users.add(user);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users",users);
        return "forum";
    }
    @Resource
    private ReviewService reviewService;
    @RequestMapping("/b")
    public String queryAll(Model model){
        List<Review> reviews = reviewService.getReviews();
        model.addAttribute("reviews", reviews);
        return "forum2";
    }

    @Resource
    private UserService userService;
    @RequestMapping("/login")
    public String loginVertify(String username, String password, String login, HttpSession httpSession){


        boolean certify = userService.vertify(username, password);
        if (certify == true) {
            httpSession.setAttribute("certify",certify);
            return "first";
        }
        return "error";

    }
    @RequestMapping("/uploadservice")
    public String uploadservice(String author,String title,String category,String content){
        int i = userService.uploadPage(author, title, category, content);
        return "redirect:/forum";
    }

    @RequestMapping("/upload")
    public String uploadHtml(){
        return "upload";
    }

    @RequestMapping("/forum")
    public String forum(Model model){
        List<Reviews> reviews = userService.showPages();
        model.addAttribute("reviews",reviews);
        System.out.println(reviews);
        return "forum";
    }

    @RequestMapping("/page")
    public String page(String title,String author,Model model){
        System.out.println(title);
        System.out.println(author);
        Reviews reviews = userService.showTitle(title, author);
        model.addAttribute("reviews",reviews);
        System.out.println(reviews);
        return "page";
    }

}
