package org.example.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.example.entity.CommonResult;
import org.example.feign.CalculateFeignClient;
import org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
根据数字间的加减乘除来定义get/post/put/delete
*/
@RequestMapping("/numberUpdated")
@RestController
public class NumberUpdatedController {
    @Resource
    private CalculateFeignClient calculateFeignClient;

    @GetMapping("/getSum")
    @CircuitBreaker(name = "circuitBreakerA",fallbackMethod = "fallbackGetSum")
    public CommonResult<Integer> getSum(@RequestParam(value = "A") Integer A,
                                        @RequestParam(value = "B") Integer B) {
        return calculateFeignClient.add(A,B);
    }
    public CommonResult<Integer> fallbackGetSum(Integer A, Integer B,Throwable T) {
        CommonResult<Integer> result = new CommonResult<>();
        result.setCode(404);
        result.setResult(null);
        result.setMessage("发生A服务降级");
        System.out.println("发生A服务降级");
        return result;
    }
    @GetMapping("/getDifference")
    @CircuitBreaker(name = "circuitBreakerB",fallbackMethod = "fallbackGetDifference")
    public CommonResult<Integer> getDifference(@RequestParam(value = "A") Integer A,
                                               @RequestParam(value = "B") Integer B) {
        return calculateFeignClient.subtract(A,B);
    }
    public CommonResult<Integer> fallbackGetDifference(Integer A, Integer B,Throwable T) {
        CommonResult<Integer> result = new CommonResult<>();
        result.setCode(404);
        result.setResult(null);
        result.setMessage("发生B服务降级");
        System.out.println("发生B服务降级");
        return result;
    }
    @GetMapping("/getSumV2")
    @Bulkhead(name = "bulkheadC",fallbackMethod = "fallbackGetSumV2")
    public CommonResult<Integer> getSumV2(@RequestParam(value = "A") Integer A,
                                        @RequestParam(value = "B") Integer B) {
        return calculateFeignClient.add(A,B);
    }
    public CommonResult<Integer> fallbackGetSumV2(Integer A, Integer B,Throwable T) {
        CommonResult<Integer> result = new CommonResult<>();
        result.setCode(404);
        result.setResult(null);
        result.setMessage("C CANT SEVER");
        System.out.println("C发生隔离");
        return result;
    }
    @GetMapping("/getSumV3")
    @RateLimiter(name = "rateLimiterD",fallbackMethod = "fallbackGetSumV3")
    public CommonResult<Integer> getSumV3(@RequestParam(value = "A") Integer A,
                                          @RequestParam(value = "B") Integer B) {
        return calculateFeignClient.add(A,B);
    }
    public CommonResult<Integer> fallbackGetSumV3(Integer A, Integer B,Throwable T) {
        CommonResult<Integer> result = new CommonResult<>();
        result.setCode(404);
        result.setResult(null);
        result.setMessage("D CANT SEVER");
        System.out.println("D发生隔离");
        return result;
    }
}
