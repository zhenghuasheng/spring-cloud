import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * 这里用了@SpringCloudApplication注解，之前没有提过，通过源码我们看到，它整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，主要目的还是简化配置。这几个注解的具体作用这里就不做详细介绍了，之前的文章已经都介绍过
 * Created by zhenghuasheng on 2017/9/8.14:30
 *
 * http://localhost:5555/routes 地址可以查看该zuul微服务网关代理了多少微服务的serviceId；
 */
@EnableZuulProxy
@SpringCloudApplication
@ComponentScan("com")
public class ZuulApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ZuulApplication.class,args);
    }
/**
 * 可通过annotation方式初始化成bean
 */
//    @Bean
//    public AccessFilter accessFilter() {
//        return new AccessFilter();
//    }
}
