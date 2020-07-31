/*
package com.example.demo.controller;


import com.rzx.finance.entity.Role;
import com.rzx.finance.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/role")
public class RoleController {

	@Autowired
    RoleService roleService;

	*/
/**
	 * 获取角色列表
	 * @param request
	 * @return
	 *//*

	@GetMapping("/get")
	public List<Role> getRole(HttpServletRequest request, Role role) {
		return roleService.selectRole(role);
	}

	*/
/**
	 * 获取角色详情页
	 * @param request
	 * @return
	 *//*

	@GetMapping("/selectRoleById")
	public Role getRoleById(HttpServletRequest request, Long roleId) {
		return roleService.selectRoleById(roleId);
	}


	*/
/**
	 * 删除角色
	 * @param
	 * @return
	 *//*

	@PostMapping("/delete")
	public int deleteRole(@RequestBody Role role) {
		return roleService.deleteRole(role);
	}

    */
/**
     * 添加角色
     * @param
     * @return
     *//*

    @PostMapping("/add")
    public int addRole(@RequestBody Role role) {
        return roleService.insertRole(role);
    }


    */
/**
     * 修改角色
     * @param
     * @return
     *//*

	@PostMapping("/update")
	public int updateUser(@RequestBody Role role) {
        return roleService.updateRole(role);
    }


}
*/
