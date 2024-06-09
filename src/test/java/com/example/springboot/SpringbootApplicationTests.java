package com.example.springboot;

import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.Reviews;
import com.example.springboot.service.UserService;
import com.example.springboot.util.RandomNum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
        for (int i = 0; i < 10000; i++) {
            int randomNumber = RandomNum.getRandomNumber();
            if (randomNumber < 2000 || randomNumber >9000) {
                System.out.println(randomNumber);
            }
        }

    }
    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;
    @Test
    void daoTest(){
        String dateTimeString = "2024-02-23 00:00:00";


    }

}
