package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author xutu
 * @date 2020-07-09 23:10
 */
@Entity
@Table(name = "SYSTEM_USER", schema = "PUBLIC", catalog = "DEMO")
@Data
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "create_time")
    private Timestamp createTime;

}
