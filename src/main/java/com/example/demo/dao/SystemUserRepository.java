package com.example.demo.dao;

import com.example.demo.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xutu
 * @date 2020-07-09 23:42
 */

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Long> {

/*    @Query("from Staff where name like %:name%")
    List<SystemUser> getByNameIsLike(@Param("name")String name);*/

    SystemUser getById(Long id);
    SystemUser getByUsername(String name);
    void deleteById(Long id);


}
