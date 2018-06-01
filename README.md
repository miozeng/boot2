spring boot2.0升级的一些个人备注
首先是要2.0我的项目是有一些报错的，按照错误信息提醒可以一一解决                           
2.0，基于 Java 8，支持 Java 9。也就是8.0以下的环境是不能用2.0的                              
支持了响应式编程，这个在下面会有更多的说明          
支持HTTP2 

支持  Kotlin   
            
支持 Quartz：你可以加入spring-boot-starter-quartz starter来启用。而且支持基于内存和基于jdbc两种存储。

简化了Security
Spring Security的 filter 现在可以自动配置如下类型了： ASYNC, ERROR, and REQUEST 。这样就让Spring Boot中的配置和Spring Security默认配置保持一致了。

Spring Session
Spring Session的 filter 现在支持自动配置如下dispatcher类型 ASYNC, ERROR, and REQUEST 。同样是为了让Spring Boot的配置与Spring Session的默认配置保持一致。值得注意的是从Spring Session 2.0起, Mongo和GemFire 将不再被支持。

Servlet Filters
针对一个Filter默认的dispatcher类型现在为 DipatcherType.REQUEST，这样就保证了Spring Boot和Servlet默认的配置统一了。

Spring Session
Spring Session的 filter 现在支持自动配置如下dispatcher类型 ASYNC, ERROR, and REQUEST 。同样是为了让Spring Boot的配置与Spring Session的默认配置保持一致。值得注意的是从Spring Session 2.0起, Mongo和GemFire 将不再被支持。


支持JOOQ
JOOQ 是基于Java访问关系型数据库的工具包。JOOQ 既吸取了传统ORM操作数据的简单性和安全性，又保留了原生sql的灵活性，它更像是介于 ORMS和JDBC的中间层。对于喜欢写sql的码农来说，JOOQ可以完全满足你控制欲，可以是用Java代码写出sql的感觉来。

引入了Micrometer 增强了对 Micrometer 的集成。RabbitMQ、JVM 线程和垃圾收集指标会自动进行 instrument 监控，异步控制器(controller)也会自动添加到监控里。通过集成，还可以对 InfluxDB 服务器进行监控

Redis方面， 默认引入了Lettuce, 替代了之前的jedis作为底层的redis链接方式

支持了Thymeleaf 3
支持OAuth 2.0
依赖组件的更新
Jetty 9.4
Tomcat 8.5
Flyway 5
Hibernate 5.2
Gradle 3.4
Thymeleaf 3.0

Spring Framework 5.0
Spring Boot 2.0 是建立在Spring Framework 5.0之上的（最低要求）

## WebFlux 和 WebFlux.fn支持
Spring Boot 2.0 提供了一个新的starter ，用来支持Reactive Spring web frameworks。该starter为spring-boot-starter-webflux。其中Reactor Netty是默认的web引擎(spring-boot-starter-reactor-netty)。
以前有几个Spring Boot starter是依靠Spring MVC和spring-boot-starter-web传递的。 为了对Spring WebFlux的支持，spring-boot-starter-mustache和spring-boot-starter-thymeleaf不再依赖spring-boot-starter-web。现在你要自己选择并添加spring-boot-starter-web或spring-boot-starter-webflux作为依赖。

Reactor 入门与实践
https://studygolang.com/articles/11341?fr=sidebar
所有代码学习来自：
http://javasampleapproach.com/spring-framework/spring-webflux/springboot-webflux-annotation-based-programming-model
http://javasampleapproach.com/spring-framework/spring-boot/springboot-webflux-functional-restapis


注意com.mio.boot2.router.RoutingConfiguration 是基于 Functional 函数式路由实现 RESTful API

### Reactive数据库支持

Spring Boot 2.0 对一下的数据库提供了自动配置（ auto-configuration ）的reactive的支持：
MongoDB (spring-boot-starter-data-mongodb-reactive)
Redis (spring-boot-starter-data-redis-reactive)
Cassandra (spring-boot-starter-data-cassandra-reactive)

redis的Reactive和Lettuce可以参考
https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:reactive

更多可以参考
http://blog.didispace.com/Spring-Boot-2-0-%E6%96%B0%E7%89%B9%E6%80%A7%E5%92%8C%E5%8F%91%E5%B1%95%E6%96%B9%E5%90%91/
