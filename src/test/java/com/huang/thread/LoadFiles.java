package com.huang.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author DaTou
 * @Description 任务描述:解析文件,使用Spring的线程池读取多个文件
 * @Date 2020/10/27
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoadFiles {


    @Resource
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolExecutor threadPoolExecutor;

    @Test
    public void load(){
        String filePath = "";
        List<String> fileAllPath = readFilePath(filePath);

    }

    public List<String> readFilePath(String filePath){
        List<String> list = new ArrayList<>();
        //1.读取文件夹

        //2.循环读取每个文件的路径,并存放在List当中

        return list;
    }

}
class DataLoad implements Runnable{

    public DataLoad(String filePath){
        this.filePath = filePath;
    }

    private String filePath;

    @Override
    public void run() {
        //1.读取文件 提示:可以使用BufferReader

        //2.将每行数据的house_property_id为32位的数据提取出来并放到集合里,输出到控制台,
        /**
         * 将下面这行数据截取
         * update svc_user_house_property_relation set house_property_id = 'a946ffe73e364bfd9e3dff79b2f9c67e' where house_property_id = '33569820';
         * 变成
         * a946ffe73e364bfd9e3dff79b2f9c67e并输出到控制台
         * 输出格式  "当前线程的名字:a946ffe73e364bfd9e3dff79b2f9c67e"
         * 提示:如下
         * System.out.println(Thread.currentThread().getName()+":"+a946ffe73e364bfd9e3dff79b2f9c67e);
         */

    }
}
