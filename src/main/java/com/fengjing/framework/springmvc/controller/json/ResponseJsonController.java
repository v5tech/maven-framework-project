package com.fengjing.framework.springmvc.controller.json;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengjing.framework.spring.data.jpa.service.ContactService;
import com.fengjing.framework.springmvc.model.Contact;
import com.fengjing.framework.springmvc.model.Contacts;

/**
 * 返回json格式的数据
 * @author fengjing
 *
 */
@Controller
public class ResponseJsonController {
	
	@Resource
	ContactService contactService;
	
	@RequestMapping(value="/json/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contact getContactInJson(@PathVariable(value="id")int id){
		Contact contact = contactService.findById(id);
		return contact;
	}
	
	
	
	@RequestMapping(value="/json",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contacts getContactsInJson(){
		List<Contact> contact = contactService.listAll();
		Contacts contacts=new Contacts();
		contacts.setContacts(contact);
		return contacts;
	}
	
	
}
