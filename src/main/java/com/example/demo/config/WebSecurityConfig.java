package com.example.demo.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
* 安全配置
* */

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService kiteUserDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private SelfAccessDeniedHandler selfAccessDeniedHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Test
    public void test(){
        String str = passwordEncoder().encode("xutu");

        System.out.println(str);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    /**
     * 登录认证
     * @param auth 登陆管理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(kiteUserDetailsService).passwordEncoder(passwordEncoder());

    }



/*    @Override
    public void configure(WebSecurity web) throws Exception {

        //放行静态资源被拦截
        web.ignoring().antMatchers("/static/**");
        web.ignoring().antMatchers("/templates/**");

    }*/

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests().antMatchers("/css/**","/js/**","/lib/**","/*.ico").permitAll();

        httpSecurity.authorizeRequests().anyRequest().authenticated();
        //配置登录
        httpSecurity.formLogin()
                .loginPage("/login") //登录页面地址
                .loginProcessingUrl("/login").permitAll();//登录请求接口地址（POST)

        httpSecurity.formLogin().defaultSuccessUrl("/main");


        //登录失败处理
        httpSecurity.formLogin().failureHandler(loginFailureHandler);

        //开启授权认证
/*
        httpSecurity.authorizeRequests().antMatchers("/user/get").hasAnyAuthority("system:manager:user:get");
        httpSecurity.authorizeRequests().antMatchers("/user/update").hasAnyAuthority("system:manager:user:update");
        httpSecurity.authorizeRequests().antMatchers("/user/delete").hasAnyAuthority("system:manager:user:delete");
        httpSecurity.authorizeRequests().antMatchers("/user/add").hasAnyAuthority("system:manager:user:add");

        httpSecurity.authorizeRequests().antMatchers("/role/get").hasAnyAuthority("system:manager:role:get");
        httpSecurity.authorizeRequests().antMatchers("/role/update").hasAnyAuthority("system:manager:role:update");
        httpSecurity.authorizeRequests().antMatchers("/role/delete").hasAnyAuthority("system:manager:role:delete");
        httpSecurity.authorizeRequests().antMatchers("/role/add").hasAnyAuthority("system:manager:role:add");

        httpSecurity.authorizeRequests().antMatchers("/resource/get").hasAnyAuthority("system:manager:resource:get");
        httpSecurity.authorizeRequests().antMatchers("/resource/update").hasAnyAuthority("system:manager:resource:update");
        httpSecurity.authorizeRequests().antMatchers("/resource/delete").hasAnyAuthority("system:manager:resource:delete");
        httpSecurity.authorizeRequests().antMatchers("/resource/add").hasAnyAuthority("system:manager:resource:add");
*/

//        httpSecurity.authorizeRequests().antMatchers("/login").permitAll();
//        httpSecurity.authorizeRequests().anyRequest().authenticated();


        //无权限用户提示字符串消息设置
        httpSecurity.exceptionHandling().accessDeniedHandler(selfAccessDeniedHandler);

        //开启跨域共享，跨域伪造请求限制=无效
//        httpSecurity.cors().and().csrf().disable();
        httpSecurity.csrf().disable();



    }



}
