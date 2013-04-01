package com.fengjing.framework.springmvc.exception.handling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * ∑√Œ µÿ÷∑ http://localhost:8080/maven-framework/exception.do
 * @author scott
 *
 */
@Controller
public class ExceptionController extends AbstractController {

	@Override
	@RequestMapping("exception")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 
		throw new GenericException("Oppss...System error, please visit it later");
 
	}

}
