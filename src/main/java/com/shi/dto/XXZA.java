package com.shi.dto;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author DaTou
 * @Description 学习铸安
 * @Date 2020/10/3
 **/
@Controller
public class XXZA {

    private static final String ZZXA_URL = "http://sdaqzhpx.app.zayxy.com/ques/syncQues?quesLibId=1020&token=yZnst1M3kAYz5KeUeDeiY9fPEvOoafugTdnGvcADZAP%2FAypKXG8TEvboOIGlKGGo";


    @Resource
    private RestTemplate restTemplate;

    public static void main(String[] args) {

        File file = new File("E:\\gitRespo\\start-flow\\src\\main\\resources\\static\\syncQues.json");

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            FileChannel fileChannel = fileInputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024*32);

            StringBuilder jsonBuilder = new StringBuilder();
            while (fileChannel.read(byteBuffer)>0){
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.limit()];
                byteBuffer.get(bytes);
                jsonBuilder.append(new String(bytes,"UTF-8"));
                byteBuffer.clear();
            }
            XXZADto jsonObject = JSONObject.parseObject(jsonBuilder.toString(),XXZADto.class);

            QuesList quesList = jsonObject.getData();

            int i=1;
            for (A obj:quesList.getQuesList()){
                System.out.println("题"+(i++)+":"+obj.getContent());
                for (Opts opt:obj.getOpts()){
//                    System.out.print(opt.getIsRightAnswer()==1?"(√)":"( )");
                    System.out.print(opt.getOptIndex()+":"+opt.getContent());
                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
