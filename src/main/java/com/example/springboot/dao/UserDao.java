package com.example.springboot.dao;

import com.example.springboot.pojo.Reviews;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.swing.*;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className UserDao
 * @since 1.0
 **/
@Mapper
public interface UserDao {

    @Select("select id from user where username = #{username} and password = #{password}")
    String selectByUsernameAndPassword(String username,String password);

    @Insert("insert into pages (id, author, title, category,content) values (null,  #{author},#{title}, #{category},#{content} )")
    int insertPages(
            @Param("author") String author,
            @Param("title") String title,
            @Param("category") String category,
            @Param("content") String content);

    @Select("select * from pages order by id desc ")
    List<Reviews> selectAllBlogs();

    @Select("select * from pages where title = #{title} and author = #{author}")
    Reviews selectSingleReview(String title,String author);

}
