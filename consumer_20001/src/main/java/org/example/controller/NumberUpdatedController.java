package org.example.controller;

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
    public CommonResult<Integer> getSum(@RequestParam(value = "A") Integer A,
                                        @RequestParam(value = "B") Integer B) {
        return calculateFeignClient.add(A,B);
    }
//    @GetMapping("/getDifference")
//    public CommonResult<Integer> getDifference(@RequestParam(value = "A") Integer A,
//                                               @RequestParam(value = "B") Integer B) {
//
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");
//        ServiceInstance serviceInstance = instanceList.get(0);
//        URI url = serviceInstance.getUri();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, Integer> map= new LinkedMultiValueMap<>();
//        map.add("A",A);
//        map.add("B",B);
//
//        HttpEntity<MultiValueMap<String,Integer>> request = new HttpEntity<>(map,headers);
//        return restTemplate.postForObject(url+"/calculate/sub",request,CommonResult.class);
//    }
//    @GetMapping("/getProduct")
//    public void getProduct(@RequestParam(value = "A") Integer A,
//                                            @RequestParam(value = "B") Integer B) {
//
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");
//        ServiceInstance serviceInstance = instanceList.get(0);
//        URI url = serviceInstance.getUri();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, Integer> map= new LinkedMultiValueMap<>();
//        map.add("A",A);
//        map.add("B",B);
//
//        HttpEntity<MultiValueMap<String,Integer>> request = new HttpEntity<>(map,headers);
//        restTemplate.put(url+"/calculate/mul",request);
//    }
//
//
//    @GetMapping("/getQuotient")
//    public void getQuotient(@RequestParam(value = "A") Integer A,
//                                             @RequestParam(value = "B") Integer B) {
//
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");
//        ServiceInstance serviceInstance = instanceList.get(0);
//        URI url = serviceInstance.getUri();
//
//        restTemplate.delete(url+"/calculate/div?A="+A+"&"+"B="+B,CommonResult.class);
//    }
}
