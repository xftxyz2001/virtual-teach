package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.User;
import com.xftxyz.virtualteach.service.UserService;
import com.xftxyz.virtualteach.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-05-13 14:37:33
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




