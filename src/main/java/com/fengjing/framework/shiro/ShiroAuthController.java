package com.fengjing.framework.shiro;

import java.util.Map;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.utils.Exceptions;

@Controller
@RequestMapping(value="/shiro")
public class ShiroAuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShiroAuthController.class); 
	
	private static final String LOGIN_PAGE = "shiro/login";
	private static final String unauthorizedUrl = "error/401";

	@RequestMapping(value="/login")
	public String login(HttpServletRequest request) {
		return LOGIN_PAGE;
	}
	
	@RequestMapping(value="/unauthorized")
	public String unauthorized(HttpServletRequest request) {
		return unauthorizedUrl;
	}
	
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.HEAD })
	@ResponseBody
	public String loginDialog(HttpServletRequest request) {
		return "»á»°³¬Ê±£¬ÇëÖØÐÂµÇÂ¼¡£";
	}

	@RequestMapping(value = "/timeout", method = { RequestMethod.GET })
	public String timeout() {
		return LOGIN_PAGE;
	}
	
	
	@RequestMapping(value = "/login/success",method = {RequestMethod.GET})
	@ResponseBody
	public String loginin(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		Object user = subject.getPrincipal();
		request.getSession().setAttribute(SecurityConstants.LOGIN_USER, user);
		return "µÇÂ¼³É¹¦!";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginfail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username,@ModelAttribute(value="map")Map<String, Object> map, HttpServletRequest request) {
		String msg = parseException(request);
		map.put("msg", msg);
		map.put("username", username);
		return LOGIN_PAGE;
	}
	
	
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.HEAD })
	@ResponseBody
	public String failmsg(HttpServletRequest request) {
		String msg = parseException(request);
		return msg;
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
		
		String msg = "ÆäËû´íÎó£¡";
		if (error != null) {
			if (error.equals(UnknownAccountException.class))
				msg = "Î´ÖªÕÊºÅ´íÎó£¡";
			else if (error.equals(IncorrectCredentialsException.class))
				msg = "ÃÜÂë´íÎó£¡";
			else if (error.equals(IncorrectCaptchaException.class))
				msg = "ÑéÖ¤Âë´íÎó£¡";
			else if (error.equals(AuthenticationException.class))
				msg = "ÈÏÖ¤Ê§°Ü£¡";
			else if (error.equals(DisabledAccountException.class))
				msg = "ÕËºÅ±»¶³½á£¡";
		}
		return "µÇÂ¼Ê§°Ü£¬" + msg;
	}
	
}
