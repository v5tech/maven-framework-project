package com.fengjing.framework.shiro;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springside.modules.utils.Exceptions;


/**
 * ShiroAuthController负责打开登录页面(GET请求)和登录出错页面(POST请求)
 * 真正登录的POST请求由Filter完成
 * @author scott
 *
 */

@Controller
@RequestMapping(value="/shiro")
public class ShiroAuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShiroAuthController.class); 
	
	private static final String LOGIN_PAGE = "shiro/login";
	private static final String unauthorizedUrl = "error/401";
	
	
	/**
	 * 负责打开登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request) {
		return LOGIN_PAGE;
	}
	
	/**
	 * 负责打开未授权页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/unauthorized")
	public String unauthorized(HttpServletRequest request) {
		return unauthorizedUrl;
	}
	
	@RequestMapping(value = "/login/success")
	public String loginin(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		Object user = subject.getPrincipal();
		request.getSession().setAttribute(SecurityConstants.LOGIN_USER, user);
		return "登录成功!";
	}
	
	/**
	 * 登录出错页面(POST请求)
	 * @param username
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, Model model, HttpServletRequest request) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		String msg = parseException(request);
		model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, msg);
		return LOGIN_PAGE;
	}
	
	private String parseException(HttpServletRequest request) {
		String errorString = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		Class<?> error = null;
		try {
			if (errorString != null) {
				error = Class.forName(errorString);
			}
		} catch (ClassNotFoundException e) {
			LOG.error(Exceptions.getStackTraceAsString(e));
		} 
		
		String msg = "其他错误！";
		if (error != null) {
			if (error.equals(UnknownAccountException.class))
				msg = "未知帐号错误！";
			else if (error.equals(IncorrectCredentialsException.class))
				msg = "密码错误！";
			else if (error.equals(IncorrectCaptchaException.class))
				msg = "验证码错误！";
			else if (error.equals(AuthenticationException.class))
				msg = "认证失败！";
			else if (error.equals(DisabledAccountException.class))
				msg = "账号被冻结！";
		}
		return "登录失败，" + msg;
	}
	
}
