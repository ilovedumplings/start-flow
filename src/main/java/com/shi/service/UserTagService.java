package com.shi.service;

import com.shi.mybatis.mapper.UserTagMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author DaTou
 * @Description
 * @Date 2020/10/21
 **/
@Service
@Slf4j
public class UserTagService {

    @Resource
    private UserTagMapper userTagMapper;

    @Async("threadPoolTaskExecutor")
    @Transactional(rollbackFor = Exception.class)
    public void findAll(){
        log.debug("time sleep begin : 2000s");
        try {
            TimeUnit.SECONDS.sleep(2000);
        } catch (InterruptedException e) {
            log.error("sleep interrupted",e);
            Thread.currentThread().interrupt();
        }
        log.debug("time sleep over!");
    }
}
