package com.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenghuasheng on 2017/4/14.10:47
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;


    /**
     * 调用的方法 需和熔断器指定callback方法的返回值保持一致，调用方法发生exception后将会返回callback方法的返回值
     * @return
     * @throws Exception
     */
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public Map<String,Object> addService() throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        String result =  restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
        map.put("addResult", result);
//        throw new Exception("add error");
        return map;
    }
    public Map<String,Object> addServiceFallback() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("error","error");
        return map;
    }

}
