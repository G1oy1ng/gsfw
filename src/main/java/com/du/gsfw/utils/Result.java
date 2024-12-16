package com.du.gsfw.utils;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result<T> {
    private int code;
    private String message;
    private Boolean success;
    private T data;
    private Result() {
    }


    public static <T> Result<T> success() {
        return new Result<T>().setSuccess(true)
                .setCode(ResultCode.SUCCESS).setMessage("操作成功");
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>().setSuccess(true)
                .setCode(ResultCode.SUCCESS)
                .setMessage("操作成功").setData(data);
    }

    public static <T> Result<T> fail(){
        return new Result<T>().setSuccess(false)
                .setCode(ResultCode.ERROR).setMessage("操作失败");
    }
}
