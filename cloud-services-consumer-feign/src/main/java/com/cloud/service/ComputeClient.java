package com.cloud.service;

import com.cloud.config.EurekaAuthConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhenghuasheng on 2017/4/13.17:07
 */
@FeignClient(value = "compute-service",fallback = ComputeClientHystrix.class, configuration = EurekaAuthConfiguration.class)
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}