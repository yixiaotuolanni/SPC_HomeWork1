package org.example.feign;

import org.example.entity.CommonResult;
import org.example.rule.ReactorCustomLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Provider")
//@LoadBalancerClient
@LoadBalancerClient(
        name = "Provider",
        configuration = ReactorCustomLoadBalancerConfiguration.class
)
public interface CalculateFeignClient {

    @GetMapping("/calculate/add")
    CommonResult<Integer> add(@RequestParam(value = "A") Integer A,
                                     @RequestParam(value = "B") Integer B);
//    @PostMapping("/calculate/sub")
//    CommonResult<Integer> subtract(@RequestParam(value = "A") Integer A,
//                                   @RequestParam(value = "B") Integer B);
//    @PutMapping("/calculate/mul")
//    CommonResult<Integer> multiple(@RequestParam(value = "A") Integer A,
//                                          @RequestParam(value = "B") Integer B);
//    @DeleteMapping("/calculate/div")
//    CommonResult<Double> division(@RequestParam(value = "A") Integer A,
//                                         @RequestParam(value = "B") Integer B);
}
