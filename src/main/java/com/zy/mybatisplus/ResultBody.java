package com.zy.mybatisplus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultBody<T> {
    private String code = "0";
    private String message = "成功";
    private T data = null;
}
