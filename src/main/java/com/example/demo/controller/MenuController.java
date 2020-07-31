package com.example.demo.controller;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  @author: xutu
 *  @Description: 目录菜单
 */ 
@RestController
@RequestMapping("/resource")
public class MenuController {

/*	@Autowired
    private ResourceService resourceService;




	*//**
	 * 获取菜单列表
	 * @param request
	 * @return
	 *//*
	@GetMapping("/get")
	@JsonView(Menu.OneMenuView.class)
	public Menu getResource(HttpServletRequest request) {

		Menu menu = resourceService.getMenu();

		return menu;

	}*/

}
