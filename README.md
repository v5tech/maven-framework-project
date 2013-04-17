# maven-framework-project
==================================
* 该项目基于maven3.0构建的，项目中融合了<em>Struts1</em>、<em>Struts2</em>、<em>Spring</em>、<em>SpringMVC</em>、<em>Hibernate</em>、<em>Ibatis</em>、<em>MyBatis</em>、<em>Spring Data JPA</em>、<em>Spring JDBC</em>、<em>Spring DWR</em>。页面展现这里使用Struts1、Struts2、SpringMVC（jsp视图、velocity视图、freemarker视图、pdf视图、excel视图、xml视图、json视图等）。是一个综合性的项目。

* 该项目后期会陆续集成Spring的一些好的框架进来比如说Spring Web Flow、Jbpm、WebService、Compass、Solr、nutch等。总之是一个综合性的项目。该项目不处理业务，主要是把目前自己工作中用到过的各种框架糅合到一个项目中。纯粹是一个jee框架的糅合，主要是介绍各种技术。

* 项目中的持久化框架sql语句的跟踪分别采用<strong>log4jdbc</strong>结合<strong>log4j</strong>和<strong>p6spy</strong>,在控制台可以看到完整的sql语句。

* 该项目中使用到的技术均与Spring已集成。除了DWR与Spring集成使用xml文件中配置bean外 其他的bean均使用注解完善。每一个与数据库有关的都有事务处理。

* Spring  JAX-WS请参考[http://jax-ws-commons.java.net/](http://jax-ws-commons.java.net/)

* Spring整合dwr时dwr版本很关键,否则报莫名其妙的错误,具体的整合方式参照[http://www.butterdev.com/category/dwr/](http://www.butterdev.com/category/dwr/)

# 项目包结构图
![src/main/resources/package.jpg](src/main/resources/package.jpg)

# 项目中所使用框架版本信息
1. Struts1 1.3.10
2. Struts2 2.3.8
3. Spring 3.2.1.RELEASE
4. Hibernate 4.2.0.Final
5. ibatis 2.3.4.726
6. MyBatis 3.1.1
7. Spring Data JPA 1.3.0.RELEASE
8. DWR 3.0.M1(该版本jar包在跟Spring整合使用注解方式时会有问题,建议使用项目中的dwr.jar)
9. Spring Security 3.1.3.RELEASE
10. log4jdbc 1.2 采用log4jdbc跟踪sql语句 查看[src/main/resources/log4j.xml](src/main/resources/log4j.xml)
11. p6spy 1.3 采用p6spy跟踪sql语句 详细查看[src/main/resources/spy.properties](src/main/resources/spy.properties)文件

# 项目托管
* <del>SVN地址：http://maven-framework-project.googlecode.com/svn/trunk/</del> (限于大陆google code 不稳定,导致经常无法访问,该地址已不在同步,建议使用github地址)
* GitHub地址：https://github.com/sxyx2008/maven-framework-project/

最后希望有兴趣的朋友可以加入进来，大家一起完善他。把自己的技术分享出来。如有任何问题可以与我联系

# 联系方式
* QQ：<em>184675420</em>
* Email：<em>sxyx2008@gmail.com</em>
