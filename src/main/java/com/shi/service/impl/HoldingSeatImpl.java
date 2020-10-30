package com.shi.service.impl;

import com.shi.service.HoldingSeatInterface;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DaTou
 * @Description
 * @Date 2020/10/29
 **/
@Service
@Slf4j
public class HoldingSeatImpl implements HoldingSeatInterface {

    private static final String LoginUrl="http://authserver.xju.edu.cn/authserver/login?service=http://zwyy.lib.xju.edu.cn/loginall.aspx?page=center";

    private static final String password = "/5TnAcB4FZ7tVsnHKCAUgFKBSaLyfaRNBAcQT7O4mw1fmlPPqW5WSAzzDkrhGc3LVPBJTTqyzRB1JAJEiFAgXq3g5AIIyiZMUpvYgX8z10g=";

    private static final String username = "20171011225";

    @Resource
    private RestTemplate restTemplate;


    @Override
    public void requestUrl() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String,String>> mapHttpEntity = new HttpEntity<>(buildLoginFormMsg(null),httpHeaders);
        ResponseEntity<String> content = restTemplate.postForEntity(LoginUrl,mapHttpEntity,String.class);
        log.info(content.getBody());
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        //first request to login page
        ResponseEntity responseEntity = restTemplate.exchange(LoginUrl,HttpMethod.GET,null,String.class);
        String jSessionId = responseEntity.getHeaders().get("Set-Cookie").get(0).split(";")[0];

        MultiValueMap multiValueMap = buildLoginFormMsg(responseEntity.getBody().toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        httpHeaders.set(HttpHeaders.COOKIE,jSessionId);
        httpHeaders.set(HttpHeaders.COOKIE,"org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN");

        HttpEntity<MultiValueMap> mapHttpEntity = new HttpEntity<>(multiValueMap,httpHeaders);
        ResponseEntity<String> content = restTemplate.postForEntity(LoginUrl,mapHttpEntity,String.class);
        content.getHeaders().get("Location");
        System.out.println(content);
    }

    /**
     * 得到登录表单里面hidden里得信息
     */
    private static MultiValueMap<String,String > buildLoginFormMsg(String html){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("username",username);
        map.add("password",password);

            Document document = Jsoup.parse(html);
            Element elements = document.getElementById("casLoginForm");
            Elements inputElement = elements.getElementsByTag("input");
            String lt = null;
            String dllt = null;
            String execution = null;
            String _eventId = null;
            String rmShown = null;
            for (Element input:inputElement){
                if (input.attr("name").equals("lt")){
                    lt = input.attr("value");
                }else if (input.attr("name").equals("dllt")){
                    dllt = input.attr("value");
                }else if (input.attr("name").equals("execution")){
                    execution = input.attr("value");
                }else if (input.attr("name").equals("_eventId")){
                    _eventId = input.attr("value");
                }else if (input.attr("name").equals("rmShown")){
                    rmShown = input.attr("value");
                }
            }
            map.add("lt",lt);
            map.add("dllt",dllt);
            map.add("execution",execution);
            map.add("_eventId",_eventId);
            map.add("rmShown",rmShown);
        return map;
    }

    /**
     * @return
     */
    private Map<String,Object> buildRequestHeader(){
        Map<String,Object> map = new HashMap<>();
        Cookie cookie = new Cookie("ASP.NET_SessionId","a4o4qn45la2f4ge3yzzkbe45");
        map.put("cookie",cookie);
        return map;
    }
}
