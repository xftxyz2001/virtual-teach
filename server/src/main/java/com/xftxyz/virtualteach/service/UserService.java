package com.xftxyz.virtualteach.service;

import com.xftxyz.virtualteach.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.virtualteach.vo.req.LoginReq;
import com.xftxyz.virtualteach.vo.resp.LoginResp;

/**
* @author 25810
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-05-13 14:37:33
*/
public interface UserService extends IService<User> {

    LoginResp login(LoginReq loginReq);
}
