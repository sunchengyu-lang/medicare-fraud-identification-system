package com.mfis.medicarefraudidentificationsystembackend.controller;

import com.mfis.medicarefraudidentificationsystembackend.pojo.Result;
import com.mfis.medicarefraudidentificationsystembackend.pojo.User;
import com.mfis.medicarefraudidentificationsystembackend.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:5173")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //没有占用
            //注册
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        //判断该用户名是否存在

        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        //判断密码是否正确
        if (password.equals(loginUser.getPassword())) {

            return Result.success(loginUser);

        }
        return Result.error("密码错误");
    }

    @PostMapping("/userInfo")
    public Result<User> userInfo(String username) {
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success("更新成功");
    }
}
