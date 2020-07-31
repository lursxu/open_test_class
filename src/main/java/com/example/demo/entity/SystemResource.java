package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author xutu
 * @date 2020-07-09 23:10
 */
@Entity
@Table(name = "SYSTEM_RESOURCE", schema = "PUBLIC", catalog = "DEMO")
public class SystemResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pid;
    private String name;
    private String url;
    private byte type;
    private int sort;
    private Timestamp updateTime;
    private Timestamp createTime;

}
