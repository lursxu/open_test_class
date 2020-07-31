package com.example.demo.Service.impl;


import com.example.demo.dao.SystemUserRepository;
import com.example.demo.entity.SecurityUser;
import com.example.demo.entity.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component(value = "kiteUserDetailsService")
public class SecurityUserDetailsServiceImpl implements UserDetailsService {
/*
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private ResourceMapper resourceMapper;*/

    @Autowired
    private SystemUserRepository systemUserRepository;

    private static Logger logger = LoggerFactory.getLogger(SecurityUserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("用户[{}]正在登陆，加载用户信息...", username);


        //1.查询用户
        SystemUser systemUser = systemUserRepository.getByUsername(username);

        if (systemUser == null) {

            logger.warn("用户[{}]不存在", username);

            throw new UsernameNotFoundException(username);
        }

        //5.封装框架用户信息
        String password = systemUser.getPassword();
        String name = systemUser.getName();
//        boolean enabled = user.isEnabled();
//        boolean accountNonExpired = user.isAccountNonExpired();
//        boolean accountNonLocked = user.isAccountNonLocked();
//        boolean credentialsNonExpired = user.isCredentialsNonExpired();
//        String realName = user.getRealName();
//        String unit = user.getUnit();
//        String duty = user.getDuty();

        //权限列表
        Set<SimpleGrantedAuthority> authorityList = new LinkedHashSet<>();

        SecurityUser securityUser = new SecurityUser(username, password, authorityList);

        return securityUser;

        /*

        //2.查询用户角色
        Long userId = user.getUserId();

        List<Role> roles = roleMapper.selectUserRolesByUserId(userId);

        //3.查询角色权限
        List<Resource> resources = new ArrayList<Resource>();

        for (Role role : roles) {

            Long roleId = role.getRoleId();

            boolean roleValid = RoleUtil.isRoleValid(role);

            if(!roleValid) continue;//角色无效-->继续

            List<Resource> subResource = resourceMapper.selectRoleResourceByRoleId(roleId);

            resources.addAll(subResource);

        }

        //4.封装用户权限

        //权限列表
        Set<SimpleGrantedAuthority> authorityList = new LinkedHashSet<>();

        //基于角色权限封装
        for (Role role : roles) {

            boolean roleValid = RoleUtil.isRoleValid(role);

            if(!roleValid) continue;//角色无效-->继续

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getTag());

            authorityList.add(simpleGrantedAuthority);

        }

        //基于资源权限封装
        for (Resource resource : resources) {

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(resource.getResourceTag());

            authorityList.add(simpleGrantedAuthority);

        }



*/

    }






}
