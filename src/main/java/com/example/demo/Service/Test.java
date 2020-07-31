package com.example.demo.Service;

import com.example.demo.DemoApplication;
import com.example.demo.dao.SystemUserRepository;
import com.example.demo.entity.SystemUser;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xutu
 * @date 2020-07-10 00:08
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class Test {

    @Autowired
    private SystemUserRepository systemUserRepository;

   @org.junit.Test
    public void contextLoads() {

        SystemUser systemUser = systemUserRepository.getById(12L);

        Assert.assertNotNull(systemUser);

    }

}
