package com.example.springboot.service;

import com.example.springboot.dao.StudentDao;
import com.example.springboot.pojo.User;

/**
 * @author Jackasher
 * @version 1.0
 * @className StudentService
 * @since 1.0
 **/
public interface StudentService {
    User queryStudent(String id);
}
