package com.example.springboot;

import com.example.springboot.pojo.MyDataSource;
import com.example.springboot.service.Impl.SayHelloImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.example.springboot.dao")
public class SpringbootApplication {

    @Autowired
    private SayHelloImpl sayHelloImpl;

    public static void main(String[] args) {

        System.out.println("SpringApplication执行前");
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        System.out.println("SpringApplication执行后");
        MyDataSource myDataSource = run.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }




}


