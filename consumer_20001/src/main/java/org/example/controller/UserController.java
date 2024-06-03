package org.example.controller;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import jakarta.annotation.Resource;
import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/signIn")
    public CommonResult<User> newUser(@RequestParam(value = "id") String id,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "password") String password) {

        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = instanceList.get(0);
        URI url = serviceInstance.getUri();
        System.out.println(url);
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setName(name+"由第一个consumer处理");
        return restTemplate.postForObject(url+"/userDao/newUser",user,CommonResult.class);
    }
}
