# maven-framework-project
==================================
* 该项目基于maven3.0构建的，项目中融合了<em>Struts1</em>、<em>Struts2</em>、<em>Spring</em>、<em>SpringMVC</em>、<em>Hibernate</em>、<em>Ibatis</em>、<em>MyBatis</em>、<em>Spring Data JPA</em>、<em>Spring JDBC</em>、<em>Spring DWR</em>。页面展现这里使用Struts1、Struts2、SpringMVC（jsp视图、velocity视图、freemarker视图、pdf视图、excel视图、xml视图、json视图等）。是一个综合性的项目。

* 该项目后期会陆续集成Spring的一些好的框架进来比如说Spring Web Flow、Jbpm、WebService、Compass、Solr、nutch等。总之是一个综合性的项目。该项目不处理业务，主要是把目前自己工作中用到过的各种框架糅合到一个项目中。纯粹是一个jee框架的糅合，主要是介绍各种技术。

* 项目中的持久化框架sql语句的跟踪分别采用<strong>log4jdbc</strong>结合<strong>log4j</strong>和<strong>p6spy</strong>,在控制台可以看到完整的sql语句。

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


# 使用说明
1. 手动创建数据库(framework、hibernate4、jdbc_ibatis_mybatis、spring_security)
   * framework(会自动创建表) 用来演示spring data jpa 
   * hibernate4(会自动创建表) 用来演示 hibernate4
   * jdbc_ibatis_mybatis(自动创建表和导入数据) 用来演示spring jdbc、ibatis、mybatis,使用同一个数据库、同一个数据源、同一个事务管理
   * spring_security(自动创建表和导入数据) 用来演示spring security
2. 修改[src/main/resources/jdbc.properties](src/main/resources/jdbc.properties)文件 里面存放数据库连接信息.主要这里的driver和jdbc url与大家平常见到的不太一致,这是由于使用了sql语句跟踪的框架
	* log4jdbc (spring jdbc、ibatis、mybatis、spring data jpa、spring security使用他跟踪sql)
	* p6spy (hibernate使用p6spy跟踪sql)
	* log4jdbc要结合<em>log4j</em>来使用
	* p6spy要结合[src/main/resources/spy.properties](src/main/resources/spy.properties)配置文件
	* 注意查看[src/main/resources/log4j.xml](src/main/resources/log4j.xml)文件
3. 鉴于配置方便这里将各持久化框架的数据源集中配置在[src/main/resources/applicationContext.xml](src/main/resources/applicationContext.xml)文件中,其中spring jdbc、ibatis、mybatis,使用同一个数据库、同一个数据源、同一个事务管理
4. 以上配置完成后您可采用一下方式运行该工程,详细使用方式请查看[pom](pom.xml)中的配置或者各插件的帮助文档
   * 跳过单元测试 <em>mvn -Dmaven.test.skip=true</em> [参照](http://maven.apache.org/surefire/maven-surefire-plugin/examples/skipping-test.html)
   * tomcat6 <em>mvn tomcat:run</em>
   * tomcat7 <em>mvn tomcat7:run</em>
   * jetty <em>mvn jetty:run</em>
   * jboss <em>mvn jboss:start</em> <em>mvn jboss:hard-deploy</em>
   * jboss-as <em>mvn jboss-as:deploy</em> <em>mvn jboss-as:run</em>
	
# 项目托管
* <del>SVN地址：http://maven-framework-project.googlecode.com/svn/trunk/</del> (限于大陆google code 不稳定,导致经常无法访问,该地址已不在同步,建议使用github地址)
* GitHub地址：https://github.com/sxyx2008/maven-framework-project/

最后希望有兴趣的朋友可以加入进来，大家一起完善他。把自己的技术分享出来。如有任何问题可以与我联系

# 联系方式
* QQ：<em>184675420</em>
* Email：<em>sxyx2008@gmail.com</em>
