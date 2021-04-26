package com.fu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;   // 返回一个状态码
    private String  message; // 返回信息
    private T       data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
