package com.example.springboot.service.Impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.Reviews;
import com.example.springboot.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    public List<Reviews> showPages() {
        List<Reviews> reviews = userDao.selectAllBlogs();
        return reviews;
    }

    @Override
    public Reviews showTitle(String title, String author) {
        Reviews reviews = userDao.selectSingleReview(title, author);
        return reviews;
    }

}
