import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zhenghuasheng on 2017/4/13.14:19
 */

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = {"com"})
public class EurekaApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");

        SpringApplication.run(EurekaApplication.class,args);
    }
}
