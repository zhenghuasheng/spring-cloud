package com.cloud;

import com.cloud.message.SourceSender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhenghuasheng on 2017/4/13.16:02
 */
@RestController
public class ProviderController {
    @Autowired
    private SourceSender sourceSender;

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }


    @ResponseBody
    @RequestMapping("/send")
    public String send(String name) {
        logger.info("send");
        sourceSender.sendMessage(name);
        return name;
    }
}
