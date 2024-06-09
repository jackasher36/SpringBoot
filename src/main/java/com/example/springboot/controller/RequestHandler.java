package com.example.springboot.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jackasher
 * @version 1.0
 * @className RequestHandler
 * @since 1.0
 **/
@Controller
public class RequestHandler {

    @RequestMapping("/life")
    public String life() {
        return "life";
    }

    @RequestMapping("/LostAndFound")
    public String lostAndFound() {
        return "LostAndFound";
    }

    @RequestMapping("/trade")
    public String trade() {
        return "trade";
    }

    @RequestMapping("/second")
    public String second() {
        return "second";
    }


    @RequestMapping("/first")
    public String first() {
        return "first";
    }

    @RequestMapping("/depart")
    public String depart() {
        return "depart";
    }

    @RequestMapping("/essay")
    public String essay() {
        return "essay";
    }
    @RequestMapping("/live")
    public String live() {
        return "live";
    }


}
