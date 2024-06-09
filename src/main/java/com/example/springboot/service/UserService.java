package com.example.springboot.service;

import com.example.springboot.pojo.Comment;
import com.example.springboot.pojo.Register;
import com.example.springboot.pojo.Reviews;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className UserService
 * @since 1.0
 **/
public interface UserService {

    boolean vertify(String username, String password);

    int uploadPage( @Param("title") String title,
                    @Param("author") String author,
                    @Param("content") String content,
                    @Param("category") String category);

    List<Reviews> showPages(String page);

    Reviews showTitle(String title, String author,String publictime);

    int RegisterUser(String studentId,String password,String phone);

    int addUser(String username,String password);

    Register findRegisterById(String studentId);

    List<Reviews> likeSearch(String condition);

    int postComment(String message_time, String author, String comments, HttpSession httpSession);

    List<Comment> getComments(String message_time);


}
