package com.mfis.medicarefraudidentificationsystembackend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    private Integer id;//主键ID
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String username;//账号

    @JsonIgnore//让springbootmvc把当前对象转换成json字符串的时候，忽略password，最终的json字符串中就没有password这个属性了
    private String password;//密码

    @NotEmpty
    private String name;//姓名

    private String department;
    private String job;

    @NotEmpty
    @Email
    private String email;//邮箱
    @Pattern(regexp = "^\\S{11}$")
    private String phone;
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}