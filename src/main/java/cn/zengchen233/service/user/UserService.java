package cn.zengchen233.service.user;

import cn.zengchen233.pojo.User;

import java.util.Map;

public interface UserService {
    //用户注册
    public boolean userRegister(Map<String,Object> map);

    //用户登录
    public User userLogin(String usercode);
}