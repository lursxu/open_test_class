/*
package com.example.demo.controller;


import com.rzx.finance.entity.User;
import com.rzx.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

*/
/**
 *  @author: yanghuijuan
 *  @Date: 2020/3/2 14:02
 *  @Description:
 *//*

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    UserService userService;

	*/
/**
	 * 获取用户列表
	 * @param request
	 * @return
	 *//*

	@GetMapping("/get")
	public List<User> getUser(HttpServletRequest request, User user) {

		return userService.selectUser(user);

	}

	*/
/**
	 * 获取用户详情页
	 * @param request
	 * @return
	 *//*

	@GetMapping("/selectUserByUserId")
	public User getUserByUserId(HttpServletRequest request, Long userId) {

		return userService.selectUserByUserId(userId);

	}


	*/
/**
	 * 删除用户
	 * @param
	 * @return
	 *//*

	@PostMapping("/delete")
	public int deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}

    */
/**
     * 添加用户
     * @param
     * @return
     *//*

    @PostMapping("/add")
    public int addUser(@RequestBody User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(password);
    	return userService.insertUser(user);
    }


    */
/**
     * 修改用户
     * @param
     * @return
     *//*

    @PostMapping("/update")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
*/
