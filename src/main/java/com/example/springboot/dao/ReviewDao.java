package com.example.springboot.dao;

import com.example.springboot.pojo.Review;
import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className ReviewDao
 * @since 1.0
 **/
@Mapper
public interface ReviewDao {

    @Select("select * from reviews")
    List<Review> QueryAll();
}
