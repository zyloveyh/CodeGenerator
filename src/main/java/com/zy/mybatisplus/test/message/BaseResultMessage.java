package com.zy.mybatisplus.test.message;

public interface BaseResultMessage {
    interface Code {
        String SUCCESS= "0000";
        String FAIL = "0001";
    }

    interface Message {
        String SUCCESS = "成功";
        String FAIL = "失败";
    }
}