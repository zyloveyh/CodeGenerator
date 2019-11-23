package com.zy.mybatisplus.test.message;

public interface BaseResultMessage {
    class Code {
        String SUCCESS= "0000";
        String FAILS = "0001";
    }

    class Message {
        String SUCCESS = "成功";
        String FAIL = "失败";
    }
}