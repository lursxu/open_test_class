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
@Table(name = "SYSTEM_ROLE", schema = "PUBLIC", catalog = "DEMO")
@Data
public class SystemRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roleName;

    private String roleTag;

    private Timestamp updateTime;

    private Timestamp createTime;

}
