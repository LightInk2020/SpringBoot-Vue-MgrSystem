package com.edu.dlut.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName: User
 * Description:
 * Date: 2021/9/27 14:11
 *
 * @author Crescent
 * @version 1.0
 * @since JDK 1.8
 */
@TableName("user")
//lombok 可以自动生成get和set方法  简化编程
@Data
public class User {
    //    ID是自增字段
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private Integer age;
    private String sex;
    private String address;
}
