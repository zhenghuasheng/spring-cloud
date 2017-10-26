import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka默认端口是8761
 * http://localhost:8761/eureka/apps 可以查看注册到该服务器上的一堆微服务实例的信息。
 *
 * @author zhenghuasheng
 * @date 2017/4/13
 */

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = {"com"})
public class EurekaApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");

        SpringApplication.run(EurekaApplication.class,args);
    }
}
