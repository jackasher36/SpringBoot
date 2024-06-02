package com.example.springboot.service.Impl;

import com.example.springboot.service.SayHello;
import org.springframework.stereotype.Service;

/**
 * @author Jackasher
 * @version 1.0
 * @className sayHelloImpl
 * @since 1.0
 **/
@Service
public class SayHelloImpl implements SayHello {
    @Override
    public void hello(String name) {
        System.out.println("Hello! " + name);
    }
}
