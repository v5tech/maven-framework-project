package com.fengjing.framework.ibatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengjing.framework.ibatis.model.Product;
import com.fengjing.framework.ibatis.service.ProductService;


@ContextConfiguration(locations={"classpath:spring-ibatis.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {
	
	@Resource(name="productServiceImpl")
	private ProductService productService;
	
	@Test
	public void listAll(){
		List<Product> lists=productService.listAll();
		for (Product product : lists) {
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getCategory().getId()+"\t"+product.getCategory().getName());
		}
	}
	
	@Test
	public void save(){
		Product product=new Product();
		product.setName("ipad2");
		product.setPrice(3000.f);
		product.setDescription("ipad2");
		product.setCategoryid("1");
		boolean b=productService.save(product);
		System.out.println(b);
		
	}
	
	
	@Test
	public void update(){
		Product product=productService.getModel(3);
		product.setName("´÷¶û");
		product.setDescription("´÷¶û±Ê¼Ç±¾");
		boolean b=productService.update(product);
		System.out.println(b);
		
	}
	
	
	@Test
	public void selectLikeName(){
		List<Product> lists=productService.selectLikeName("o");
		for (Product product : lists) {
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getCategory().getId()+"\t"+product.getCategory().getName());
		}
	}
}
