package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xutu
 * @description：登录失败处理
 */

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        Map<String, String> map = new HashMap<>();
        if(e instanceof AccessDeniedHandler){
            map.put("code","101");
            map.put("msg","权限不足");
        }else if(e instanceof AuthenticationEntryPoint){
            map.put("code","102");
            map.put("msg","登录过期或未登录");
        }else if(e instanceof AccountExpiredException){
            map.put("code","103");
            map.put("msg","账户过期");
        }else if(e instanceof BadCredentialsException){
            map.put("code","104");
            map.put("msg","账号密码错误");
        }else if(e instanceof DisabledException){
            map.put("code","105");
            map.put("msg","账号未激活");
        }else if(e instanceof CredentialsExpiredException){
            map.put("code","106");
            map.put("msg","证书过期");
        }else{
            map.put("code","107");
            map.put("msg","登录失败,请联系管理员");
            e.printStackTrace();
        }

        httpServletResponse.getWriter().write(JSONObject.toJSONString(map));
    }

}

