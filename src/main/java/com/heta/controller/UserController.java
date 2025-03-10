package com.heta.controller;

import com.heta.entity.User;
import com.heta.service.UserService;
import com.heta.tools.CaptchaUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 用来处理和用户有关的请求，例如对用户表的CRUD操作等
@RestController
@RequestMapping("/heta/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/captcha")
    public Map<String, Object> getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型为 JSON
        response.setContentType("application/json");
        // 禁止浏览器缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();
        // 使用 ByteArrayOutputStream 捕获验证码图片数据
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 生成验证码图片并获取验证码字符串
        String captcha = CaptchaUtils.generateCaptcha(baos);
        // 将验证码存储到会话中
        session.setAttribute("captcha", captcha);

        // 将图片数据转换为 Base64 编码
        String base64Image = Base64.getEncoder().encodeToString(baos.toByteArray());

        Map<String, Object> result = new HashMap<>();
        result.put("captchaImage", base64Image);
        result.put("captchaAnswer", captcha);
        return result;
    }


    @GetMapping("/verifyUser/{phoneNum}/{passwd}")
    public Map<String,Boolean> verifyUser(@PathVariable("phoneNum") long phoneNum,@PathVariable("passwd") String passwd){
        Map<String,Boolean> response = new HashMap<>();
        boolean result = userService.verifyUser(phoneNum,passwd);
        response.put("result",result);
        return response;
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id){
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByPhoneNum/{phoneNum}")
    public User findUserByPhoneNum(@PathVariable("phoneNum") long phoneNum){
        return userService.findUserByPhoneNum(phoneNum);
    }

    @PostMapping("/addNewUser/{captchaInput}")
    public Map<String,Boolean> addNewUser(@RequestBody User user,@PathVariable("captchaInput") String captchaInput, HttpServletRequest request){
        Map<String,Boolean> resultMap = new HashMap<>();
        HttpSession session = request.getSession();
        // 从会话中获取之前存储的验证码
        String storedCaptcha = (String) session.getAttribute("captcha");
        System.out.println(storedCaptcha);

        if (storedCaptcha == null || !storedCaptcha.equalsIgnoreCase(captchaInput)) {
            resultMap.put("rightCaptcha",false);
            return resultMap;
        }
        if(userService.findUserByPhoneNum(user.getPhoneNum())!=null){
            resultMap.put("duplicated",true);
        }else {
            resultMap.put("duplicated",false);
            userService.addNewUser(user);
        }
        return resultMap;
    }

    @GetMapping("/getUserDetailById/{id}")
    public User getUserDetailById(@PathVariable("id")int id){
        return userService.getUserDetailById(id);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @GetMapping("/getContactById/{id}")
    public  List<User> getContactById(@PathVariable int id) {
       return userService.getContactById(id);
    }

    @PutMapping("/setBanned/{id}")
    public void setBanned(@PathVariable int id){
        userService.setBanned(id);
    }

    @PutMapping("/setUnbanned/{id}")
    public void setUnbanned(@PathVariable int id){
        userService.setUnbanned(id);
    }
}
