package com.shi.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserTagMapperTest {

    @Resource
    private UserTagMapper userTagMapper;

    @Test
    void selectAll() {
        System.out.println(userTagMapper.selectAll());
    }
}