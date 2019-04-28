package com.springboot.training.mapper;

import com.springboot.training.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUsers();

}
