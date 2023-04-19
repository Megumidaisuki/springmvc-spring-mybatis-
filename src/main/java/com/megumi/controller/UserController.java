package com.megumi.controller;

import com.megumi.common.PageResult;
import com.megumi.common.ResponseResult;
import com.megumi.domain.User;
import com.megumi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseResult findUserById(@PathVariable("id") Integer id){
        User user = userService.findUserById(id);
        if(user==null){
            return new ResponseResult<>(500,"查询不到该用户");
        }else {
            return new ResponseResult<>(200, "操作成功", user);
        }
    }
    @GetMapping("/user")
    public ResponseResult findAll(){
        List<User> list = userService.findAll();
        return new ResponseResult<>(200, "查询成功",list);
    }
    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum){
        PageResult pageResult = userService.findByPage(pageSize, pageNum);
        return new ResponseResult<>(200, "查询成功",pageResult);
    }
}
