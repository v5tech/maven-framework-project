package com.fengjing.framework.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 不使用org.springframework.web.servlet.handler.SimpleUrlHandlerMapping标配
 * 访问路径依次为
 * /hello/jsp.do
 * /hello/velocity.do
 * /hello/freemarker.do
 * /hello/showuser/admin/admin.do
 * @author fengjing
 *
 */
@Controller
@RequestMapping(value="/hello",method={RequestMethod.GET})
public class HelloSpringMvcController {

	/**
	 * 请求转发到jsp页面  welcome.jsp
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/jsp")
	public ModelAndView jsp(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		ModelAndView modelAndView=new ModelAndView("welcome");
		modelAndView.addObject("message", "Hello,SpringMVC!");
		return modelAndView;
	}
	
	
	/**
	 * 请求转发到velocity页面  velocity.vm
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/velocity")
	public ModelAndView velocity(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		ModelAndView modelAndView=new ModelAndView("velocity");
		modelAndView.addObject("message", "Hello,SpringMVC!");
		return modelAndView;
	}
	
	/**
	 * 请求转发到freemarker页面  freemarker.ftl
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/freemarker")
	public ModelAndView freemarker(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		ModelAndView modelAndView=new ModelAndView("freemarker");
		modelAndView.addObject("message", "Hello,SpringMVC!");
		return modelAndView;
	}
	
	
	/**
	 * 从地址栏接受参数  /hello/showUser/admin/admin.do name为admin pwd为admin 请求转发到showuser.jsp
	 * @param username
	 * @param password
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/showuser/{name}/{pwd}")
	public String showUserName(@PathVariable(value="name")String username,@PathVariable(value="pwd")String password,ModelMap map){
		try {
			map.addAttribute("username", new String(username.getBytes("iso-8859-1"),"utf-8"));
			map.addAttribute("pwd", password);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "showuser";
	}
	
	
	
	
}
