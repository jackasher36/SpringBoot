package com.example.springboot.controller;

import com.example.springboot.pojo.*;
import com.example.springboot.service.ReviewService;
import com.example.springboot.service.StudentService;
import com.example.springboot.service.UserService;
import com.example.springboot.util.SMS;
import com.example.springboot.util.SendMsg;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SMS sms;

    @Resource
    private SendMsg sendMsg;

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
//    @RequestMapping("/a")
//    public String userTest(Model model){
//        ArrayList<Object> users = new ArrayList<>();
//        User user = new User("11", "23", 111);
//        User user2 = new User("111", "2354", 11);
//        User user3 = new User("113", "232", 21);
//        users.add(user);
//        users.add(user2);
//        users.add(user3);
//        model.addAttribute("users",users);
//        return "test";
//    }
    @Resource
    private ReviewService reviewService;
    @RequestMapping("/b")
    public String queryAll(Model model){
        List<Review> reviews = reviewService.getReviews();
        model.addAttribute("reviews", reviews);
        return "test";
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
    public String forum(Model model,String page,HttpSession httpSession){


        System.out.println(page);
        System.out.println( "page=" +  page);
        List<Reviews> reviews = userService.showPages(page);
        model.addAttribute("reviews",reviews);
        if (page == null) {
            model.addAttribute("currentPage","1");
        }else {
            model.addAttribute("currentPage",page);
        }

        System.out.println(reviews);

        return "forum3";
    }

    @RequestMapping("/page")
    public String page(String title,String author,String publictime, Model model){
        System.out.println(title);
        System.out.println(author);
        Reviews reviews = userService.showTitle(title, author,publictime);
        model.addAttribute("reviews",reviews);
        System.out.println(reviews);
        return "page5";
    }


    @RequestMapping("/sendVerificationCode")
    @ResponseBody
    public String sendVerificationCode(@RequestBody String phoneNumberJson) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // 读取JSON字符串并解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(phoneNumberJson);

        // 从JsonNode对象中提取phone字段的值
        String phoneNumber = jsonNode.get("phone").asText();
        // 输出提取的值
        System.out.println("Phone: " + phoneNumber);



        boolean b = sms.sendMessage(phoneNumber);
        System.out.println(b);

        return "{\"success\":\"true\"} ";
    }



    @RequestMapping("/register")
    public String register(Register register){
        System.out.println("register:" + register);
        //用户输入的验证码
        String verificationCode = register.getVerificationCode();
        String studentId = register.getStudentId();
        String password = register.getPassword();
        String phone = register.getPhone();
        String key = "random:number" + phone;
        //数据库里面的验证码
        String code = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis code是" + code);
        System.out.println( "verificationCode=" +  verificationCode);
        System.out.println("这两个值是否相等:" + verificationCode.equals(code));
        if (code.equals(verificationCode)) {
            int i = userService.RegisterUser(studentId, password, phone);
            System.out.println("i======" + i);

            if (i == 1) {
                int addUser = userService.addUser(studentId, password);
                System.out.println("addUSer=" + addUser);
                if (addUser == 1){
                    return "register-success";
                }else{
                    return "register-failed";
                }

            }

        }

        return "register-failed";
    }

    @RequestMapping("/search")
    public String search(Model model,String condition){
        System.out.println(condition);
        List<Reviews> reviews = userService.likeSearch(condition);
        model.addAttribute("reviews",reviews);
        return "forum3";
    }

}
