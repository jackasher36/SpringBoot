package com.example.springboot.dao;

import com.example.springboot.pojo.Review;
import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className StudentDao
 * @since 1.0
 **/

/**
 * mapper表示创建该接口的代理对象
 */
@Mapper
public interface StudentDao {

//    @Select("select * from users where id = #{id}")
    User selectById(String id);

}
