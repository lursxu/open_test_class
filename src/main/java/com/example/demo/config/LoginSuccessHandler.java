package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xutu
 * @description：登录成功处理
 */

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    protected final Log logger = LogFactory.getLog(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        SavedRequest savedRequest = this.requestCache.getRequest(httpServletRequest, httpServletResponse);

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        Map<String, Object> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","登录成功");



        if(savedRequest == null){

            logger.debug("无回调地址");
            map.put("callBack", false);

        }else{

            logger.debug("有回调地址");

            String redirectUrl = savedRequest.getRedirectUrl();

            map.put("callBack", true);
            map.put("callBackAdress", redirectUrl);

        }

        httpServletResponse.getWriter().write(JSONObject.toJSONString(map));

//        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);





    }
}
