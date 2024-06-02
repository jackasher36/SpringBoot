package com.example.springboot.pojo;

import org.springframework.stereotype.Component;

/**
 * @author Jackasher
 * @version 1.0
 * @className Review
 * @since 1.0
 **/
@Component
public class Review {
    private String id;
    private String author;
    private String title;


    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", titlt='" + title + '\'' +
                '}';
    }
}
