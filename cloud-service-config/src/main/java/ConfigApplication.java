import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zhenghuasheng on 2017/4/14.14:31
 */
@SpringBootApplication
@EnableConfigServer
@ComponentScan(value = "com.cloud")
public class ConfigApplication {

    public static void main(String[] args) {
       // SpringApplication.run(ConfigApplication.class,args);

        new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
    }
}
