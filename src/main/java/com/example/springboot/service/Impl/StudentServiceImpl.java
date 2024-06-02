package com.example.springboot.service.Impl;

import com.example.springboot.dao.StudentDao;
import com.example.springboot.pojo.User;
import com.example.springboot.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Jackasher
 * @version 1.0
 * @className StudentServiceImpl
 * @since 1.0
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public User queryStudent(String id) {
        User user = studentDao.selectById(id);
        System.out.println(user);
        return user;
    }
}
