package com.example.springboot.dao;

import com.example.springboot.pojo.Comment;
import com.example.springboot.pojo.Register;
import com.example.springboot.pojo.Reviews;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className UserDao
 * @since 1.0
 **/
@Mapper
public interface UserDao {

    /**
     * 向User表插入账户名和密码
     * @param username
     * @param password
     * @return
     */
    @Insert("insert into user (username,password) values (#{username},#{password})")
    int insertUser(String username,String password);

    /**
     * 验证用户是否存在
     * @param username
     * @param password
     * @return
     */
    @Select("select username from user where username = #{username} and password = #{password}")
    String selectByUsernameAndPassword(String username,String password);

    /**
     * 插入文章信息
     * @param author
     * @param title
     * @param category
     * @param content
     * @return
     */
    @Insert("insert into pages (id, author, title, category,content) values (null,  #{author},#{title}, #{category},#{content} )")
    int insertPages(
            @Param("author") String author,
            @Param("title") String title,
            @Param("category") String category,
            @Param("content") String content);

    /**
     * 分页展示
     * @param offset
     * @return
     */
    @Select("select * from pages order by publictime desc limit #{offset},10 ")
    List<Reviews> selectAllBlogs(int offset);

    /**
     * 具体文章显示
     * @param title
     * @param author
     * @param publictime
     * @return
     */
    @Select("select * from pages where title = #{title} and author = #{author} and publictime = #{publictime}")
    Reviews selectSingleReview(String title,String author,String publictime);

    /**
     * 手机号注册
     * @param studentId
     * @param password
     * @param phone
     * @return
     */
    @Insert("insert into register (studentId, password, phone) values (#{studentId},#{password},#{phone})")
    int insertRegister(String studentId,String password,String phone);

    /**
     * 获取注册信息
     * @param studentId
     * @return
     */
    @Select("select * from register where studentId = #{studentId}")
    Register selectRegisterById(String studentId);

    /**
     * 搜索功能
     * @param search
     * @return
     */
    @Select("select * from pages where title like '%' #{search} '%'  ")
    List<Reviews> searchLike(String search);

    /**
     * 插入评论
     * @param message_time
     * @param author
     * @param comment
     * @param username
     * @return
     */
    @Insert("insert into comments (message_time,author, comment,studentid) values (#{message_time},#{author}, #{comment},#{username}) ")
    int insertComment(String message_time,String author, String comment,String username);

    /**
     * 展示评论
     * @param message_time
     * @return
     */
    @Select("select * from comments where message_time = #{message_time} order by publishtime desc")
    List<Comment> selectComment(String message_time);


}
