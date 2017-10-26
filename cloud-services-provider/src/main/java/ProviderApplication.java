import com.cloud.message.MessageCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author zhenghuasheng
 * @date 2017/4/13
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.cloud")
@EnableBinding(MessageCenter.class)
public class ProviderApplication {
    private static final Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @StreamListener(value = MessageCenter.IN)
    public void sinkMessage(Object message){
        logger.info("StreamListener received message: "+message);
    }

}
