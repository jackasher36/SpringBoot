package com.example.springboot.service.Impl;

import com.example.springboot.dao.ReviewDao;
import com.example.springboot.pojo.Review;
import com.example.springboot.service.ReviewService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className ReviewServiceImpl
 * @since 1.0
 **/
@Service
public class ReviewServiceImpl implements ReviewService {

    @Resource
    private ReviewDao reviewDao;
    @Override
    public List<Review> getReviews() {
        List<Review> reviews = reviewDao.QueryAll();
        return reviews;
    }
}
