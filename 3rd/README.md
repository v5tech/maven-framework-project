#说明
====
3rd目录中的6个jar在maven的中央仓库中是不存在的,需要你手动上传到你的maven私服中

### jar包介绍说明
1. dwr-3.0.jar dwr 3.0 用来整合Spring 做文件上传或下载 ajax框架
2. ibatis-2.3.4.726.jar ibatis核心类库
3. itext-asian-5.2.0.jar itext pdf文档亚洲字体库支持
4. itextpdf-5.4.0.jar itext pdf核心类库
5. log4jdbc4-1.2.jar log4jdbc核心类库 使用log4jdbc跟踪sql语句
6. p6spy-1.3.jar p6spy核心类库 跟踪sql语句 注意查看[src/main/resources/spy.properties](src/main/resources/spy.properties)文件