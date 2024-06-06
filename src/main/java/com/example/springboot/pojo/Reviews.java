package com.example.springboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Jackasher
 * @version 1.0
 * @className Reviews
 * @since 1.0
 **/
@Data
public class Reviews {

    private String author;
    private String title;
    private String category;
    private String content;
    private String publictime;

}
