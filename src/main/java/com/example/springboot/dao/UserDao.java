package com.example.springboot.dao;

import com.example.springboot.pojo.Register;
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

    @Insert("insert into user (username,password) values (#{username},#{password})")
    int insertUser(String username,String password);

    @Select("select id from user where username = #{username} and password = #{password}")
    String selectByUsernameAndPassword(String username,String password);

    @Insert("insert into pages (id, author, title, category,content) values (null,  #{author},#{title}, #{category},#{content} )")
    int insertPages(
            @Param("author") String author,
            @Param("title") String title,
            @Param("category") String category,
            @Param("content") String content);

    @Select("select * from pages order by publictime desc limit #{offset},10 ")
    List<Reviews> selectAllBlogs(int offset);

    @Select("select * from pages where title = #{title} and author = #{author} and publictime = #{publictime}")
    Reviews selectSingleReview(String title,String author,String publictime);

    @Insert("insert into register (studentId, password, phone) values (#{studentId},#{password},#{phone})")
    int insertRegister(String studentId,String password,String phone);

    @Select("select * from register where studentId = #{studentId}")
    Register selectRegisterById(String studentId);

    @Select("select * from pages where title like '%' #{search} '%'  ")
    List<Reviews> searchLike(String search);

}
