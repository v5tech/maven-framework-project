package com.fengjing.framework.springmvc.controller.log4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class Log4jController extends AbstractController {

	private static final Logger logger = Logger.getLogger(Log4jController.class);
	 
	@Override
	@RequestMapping("log4j")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
 
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("message", "Hello ~ Log4j");
 
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
 
		return model;
	}

}
