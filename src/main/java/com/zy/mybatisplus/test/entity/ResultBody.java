package com.zy.mybatisplus.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultBody {
    private String code = "0";
    private String message = "成功";
    private Object data = null;
}
