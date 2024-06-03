package org.example.controlller;

import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/calculate")
@RestController
@RefreshScope
public class CalculateController {
    @Value("${msg}")
    private String msg;
    @GetMapping("/add")
    public CommonResult<Integer> add(@RequestParam(value = "A") Integer A,
                                     @RequestParam(value = "B") Integer B){
        CommonResult<Integer> commonResult = new CommonResult<>();
        Integer code;
        String message;
        Integer result;
        try{
            // 将user存储进入数据库
            code = 200;
            message = "计算两数之和;msg:"+msg;
            result = A+B;
        }catch (Exception e){
            code = 500;
            message = "defeat";
            result = null;
        }
        commonResult.setCode(code);
        commonResult.setMessage(message + "\t20000接口");
        commonResult.setResult(result);
        return commonResult;
    }
    @PostMapping("/sub")
    public CommonResult<Integer> subtract(@RequestParam(value = "A") Integer A,
                                     @RequestParam(value = "B") Integer B){
        CommonResult<Integer> commonResult = new CommonResult<>();
        Integer code;
        String message;
        Integer result;
        try{
            // 将user存储进入数据库
            code = 200;
            message = "计算两数之差";
            result = A - B;
        }catch (Exception e){
            code = 500;
            message = "defeat";
            result = null;
        }
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setResult(result);
        return commonResult;
    }
    @PutMapping("/mul")
    public CommonResult<Integer> multiple(@RequestParam(value = "A") Integer A,
                                     @RequestParam(value = "B") Integer B){
        CommonResult<Integer> commonResult = new CommonResult<>();
        Integer code;
        String message;
        Integer result;
        try{
            // 将user存储进入数据库
            code = 200;
            message = "计算两数之积";
            result = A * B;
        }catch (Exception e){
            code = 500;
            message = "defeat";
            result = null;
        }
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setResult(result);
        return commonResult;
    }
    @DeleteMapping("/div")
    public CommonResult<Double> division(@RequestParam(value = "A") Integer A,
                                          @RequestParam(value = "B") Integer B){
        CommonResult<Double> commonResult = new CommonResult<>();
        Integer code;
        String message;
        Double result;
        try{
            // 将user存储进入数据库
            code = 200;
            message = "计算两数之商";
            result = 1.0 * A / B;
        }catch (Exception e){
            code = 500;
            message = "defeat";
            result = null;
        }
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setResult(result);
        return commonResult;
    }
}
