package com.fengjing.framework.webservice.jaxws.client;

import java.util.List;

/**
 * 在maven环境下执行mvn jaxws:wsimport 生成client端代码
 * @author scott
 *
 */
public class HelloWebServiceClient {

    public static void main(String[] args)
    {
        //To Call webservice you need its service object
        //then port to call exposed methods.
        
    	/**
         * HelloService hs = new HelloService();
         * Hello hello = hs.getHelloPort();
         * hello.sayHello("Sanumala");
         */
    	
        Hello hello = new HelloService().getHelloPort();
        System.out.println(hello.sayHello("Sanumala"));
        System.out.println(hello.sayHelloUsingSpring("Github"));
        
        List<User> users = hello.getAllUsers();
        for (User user : users) {
        	System.out.println(user.getName()+"\t"+user.getAge()+"\t"+user.getAddress()+"\t"+user.getDept().getDeptname());
		}
        User user = new User();
        
        user.setName("admin");
        user.setAge(18);
        user.setAddress("陕西西安");
        
        Dept dept=new Dept();
        
        dept.setDeptid(1);
        dept.setDeptname("研发中心");
        
		user.setDept(dept);
		
        User print = hello.print(user);
        System.out.println("\n"+print.getName()+"\t"+print.getAge()+"\t"+print.getAddress()+"\t"+print.getDept().getDeptname());
        
    }
}
