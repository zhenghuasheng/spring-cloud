package com.cloud;

import com.cloud.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenghuasheng on 2017/4/13.16:41
 */
@RefreshScope
@RestController
public class ConsumerController {

    @Autowired
    private ComputeService computeService;

    @Value("${name}")
    private String name;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> add() throws Exception {
        return computeService.addService();
    }

    @RequestMapping("/name")
    @ResponseBody
    public Map<String,Object> getName() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name",this.name);
        return map;
    }


}
