package com.example.demo.Service.impl;

import com.example.demo.Service.SystemUserService;
import com.example.demo.dao.SystemUserRepository;
import com.example.demo.entity.SystemUser;
import org.springframework.stereotype.Service;

/**
 * @author xutu
 * @date 2020-07-09 23:46
 */

@Service
public class SystemUserServiceImpl implements SystemUserService {


    private SystemUserRepository systemUserRepository;

    @Override
    public SystemUser getSystemUser(Long id) {

        SystemUser systemUser = systemUserRepository.getById(id);

        return systemUser;
    }
}
