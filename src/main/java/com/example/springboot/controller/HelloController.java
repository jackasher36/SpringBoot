package com.example.springboot.controller;

import com.example.springboot.pojo.*;
import com.example.springboot.service.UserService;
import com.example.springboot.util.SMS;
import com.example.springboot.util.SendMsg;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
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
    private UserService userService;
    @RequestMapping("/login")
    public String loginVertify(String username, String password, String login, HttpSession httpSession){


        boolean certify = userService.vertify(username, password);
        if (certify == true) {
            httpSession.setAttribute("certify",certify);
            httpSession.setAttribute("username",username);
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
    public String page(String title,String author,String publictime, Model model,HttpSession httpSession){
        Reviews reviews = userService.showTitle(title, author,publictime);
        String message_time = reviews.getPublictime();
        model.addAttribute("username",httpSession.getAttribute("username"));
        model.addAttribute("reviews",reviews);

        List<Comment> comments = userService.getComments(message_time);
        model.addAttribute("comments",comments);

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

    @RequestMapping("/register2")
    @ResponseBody
    public String register(@RequestBody User user){

        System.out.println("Heloooo????");
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        System.out.println(password);

        System.out.println("Heloooo????");
        int i = userService.addUser(username, password);


        System.out.println("i==============" +  i);
        if (i == 1) {
            return "{\"success\":\"true\"} ";
        }else {
            return "{\"success\":\"false\"} ";
        }

    }

    @RequestMapping("/search")
    public String search(Model model,String condition){
        System.out.println(condition);
        List<Reviews> reviews = userService.likeSearch(condition);
        model.addAttribute("reviews",reviews);
        return "forum3";
    }

    @RequestMapping("/postcomment")
    public String post(String title,String author, String content, @RequestParam("message_time") String message_time, HttpSession session, String author2,Model model,HttpSession httpSession){

        /**
         * 调试参数
         */
        System.out.println("title anthor content message_time author 2" +  title + author + content + message_time);

        int i = userService.postComment(message_time, author, content,session);


        Reviews reviews = userService.showTitle(title, author2,message_time);
        String message_time2 = reviews.getPublictime();
        model.addAttribute("username",httpSession.getAttribute("username"));
        model.addAttribute("reviews",reviews);

        System.out.println( "review:==============" + reviews);

        List<Comment> comments = userService.getComments(message_time2);
        model.addAttribute("comments",comments);


        return "page5";
    }

}
