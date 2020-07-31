package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SelfAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        Map<String, String> map = new HashMap<>();
        map.put("code","401");
        map.put("msg","对不起！您没有该资源的访问权限！有问题请联系管理员");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(map));

    }

}
