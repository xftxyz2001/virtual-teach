package com.xftxyz.virtualteach.vo.req;

import lombok.Data;

@Data
public class ForgetPasswordReq {

    private String login;
    private String password;
    private String code;
}
