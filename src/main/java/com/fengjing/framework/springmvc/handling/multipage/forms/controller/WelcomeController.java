package com.fengjing.framework.springmvc.handling.multipage.forms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Spring MVC Handling Multipage Forms With AbstractWizardFormControllerÈë¿Ú
 * http://localhost:8080/maven-framework/welcome.do
 * @author scott
 *
 */
public class WelcomeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("WelcomePage");
	}

}
