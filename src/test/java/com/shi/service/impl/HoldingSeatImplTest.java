package com.shi.service.impl;

import com.shi.service.HoldingSeatInterface;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class HoldingSeatImplTest {

    @Resource
    private HoldingSeatInterface holdingSeatInterface;

    @Test
    void requestUrl() {
        holdingSeatInterface.requestUrl();
    }
}