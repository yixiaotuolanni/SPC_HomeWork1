package org.example.controlller;

import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDao")
public class UserController {
    @PostMapping ("/newUser")
    public CommonResult<User> getUserById(@RequestBody User user) throws InterruptedException {
        CommonResult<User> commonResult = new CommonResult<User>();
        Integer code;
        String message;
        User result;
        try{
            // 将user存储进入数据库
            code = 200;
            message = "user在30000端口缓存成功";
            result = user;
        }catch (Exception e){
            code = 500;
            message = "defeat";
            result = null;
        }
        Thread.sleep(3000l);
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setResult(result);
        return commonResult;
    }
}