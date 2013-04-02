package com.fengjing.framework.springmvc.handling.multipage.forms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.fengjing.framework.springmvc.handling.multipage.forms.model.User;
import com.fengjing.framework.springmvc.handling.multipage.forms.validator.UserValidator;

public class UserController extends AbstractWizardFormController{

	public UserController(){
		setCommandName("userForm");
	}
 
	@Override
	protected Object formBackingObject(HttpServletRequest request)
		throws Exception {
 
		return new User();
	}
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {
 
		//Get the data from command object
		User user = (User)command;
		System.out.println(user);
 
		//where is the finish page?
		return new ModelAndView("ResultForm", "user", user);
	}
 
	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {
 
		//where is the cancel page?
		return new ModelAndView("WelcomePage");
	}
	
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		UserValidator validator = (UserValidator) getValidator();
		//page is 0-indexed
		switch (page) {
		   case 0: //if page 1 , go validate with validatePage1Form
			validator.validatePage1Form(command, errors);
			break;
		   case 1: //if page 2 , go validate with validatePage2Form
			validator.validatePage2Form(command, errors);
			break;
		   case 2: //if page 3 , go validate with validatePage3Form
			validator.validatePage3Form(command, errors);
			break;
		}
	}
	
}
