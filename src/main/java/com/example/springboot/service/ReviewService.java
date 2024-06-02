package com.example.springboot.service;

import com.example.springboot.pojo.Review;

import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className ReviewService
 * @since 1.0
 **/
public interface ReviewService {
    List <Review> getReviews();
}
