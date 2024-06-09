package com.example.springboot.service.Impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.Comment;
import com.example.springboot.pojo.Register;
import com.example.springboot.pojo.Reviews;
import com.example.springboot.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className UserServiceImpl
 * @since 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public boolean vertify(String username,String password) {
        String s = userDao.selectByUsernameAndPassword(username, password);
        if (s != null) {
            return true;
        }
        return false;
    }

    @Override
    public int uploadPage(String title, String author, String content, String category) {
        int i = userDao.insertPages(title, author, content, category);
        return i;
    }

    @Override
    public List<Reviews> showPages(String page) {
        int i;
        System.out.println("helooooooooo??????" + page);
        boolean tmp = page != null && !page.isEmpty();;
        System.out.println("pagenull为" + tmp);
        if (tmp) {
            try {
                i = Integer.parseInt(page);
            } catch (NumberFormatException e) {
                i = 1; // 如果 page 不是一个有效的数字，则设置为默认值 1
            }
        } else {
            i = 1; // 如果 page 为 null 或为空字符串，则设置为默认值 1
        }

        int pages = (i-1)*10;
        List<Reviews> reviews = userDao.selectAllBlogs(pages);
        return reviews;
    }

    @Override
    public Reviews showTitle(String title, String author,String publictime) {
        Reviews reviews = userDao.selectSingleReview(title, author,publictime);
        return reviews;
    }

    @Override
    public int RegisterUser(String studentId, String password, String phone) {

        Register register = userDao.selectRegisterById(studentId);
        System.out.println(register);
        System.out.println("register是不是==null" + register==null);

        if (register == null) {
            int i = userDao.insertRegister(studentId, password, phone);
            return i;
        }

        return -1;
    }

    @Override
    public int addUser(String username, String password) {
        System.out.println("username ==" + username);
        System.out.println(password);
        System.out.println("password==" + password);
        int i = userDao.insertUser(username, password);
        System.out.println("i="+ i);
        if (i != 1) {
            return -1;
        }
        return i;
    }

    @Override
    public Register findRegisterById(String studentId) {
        return null;
    }

    @Override
    public List<Reviews> likeSearch(String condition) {
        List<Reviews> reviews = userDao.searchLike(condition);
        return reviews;
    }

    @Override
    public int postComment(String message_time, String author, String comments, HttpSession httpSession) {
        String username = (String) httpSession.getAttribute("username");
        int i = userDao.insertComment(message_time, author, comments,username);
        return i;
    }

    @Override
    public List<Comment> getComments(String message_time) {
        List<Comment> comments = userDao.selectComment(message_time);
        return comments;
    }

}
