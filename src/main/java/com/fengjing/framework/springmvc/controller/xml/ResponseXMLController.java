package com.fengjing.framework.springmvc.controller.xml;

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
 * 返回xml格式的数据
 * @author fengjing
 *
 */
@Controller
public class ResponseXMLController {
	
	@Resource
	ContactService contactService;
	
	/**
	 * 根据id查询一条xml数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/xml/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Contact getContactInXML(@PathVariable(value="id")int id){
		Contact contact = contactService.findById(id);
		return contact;
	}
	
	
	/**
	 * 查询多个xml数据
	 * @return
	 */
	@RequestMapping(value="/xml",produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Contacts getContactsInXML(){
		List<Contact> contact = contactService.listAll();
		Contacts contacts=new Contacts();
		contacts.setContacts(contact);
		return contacts;
	}
	
	
}
