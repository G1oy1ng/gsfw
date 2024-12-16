package com.du.gsfw.utils;

import com.du.gsfw.constant.enums.CodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(chain = true)
public class R<T> {

    private String code;

    private String msg;

    private T result;

    public R() {};

    public static R success() {
        return success();
    }

    public static <T> R success(T data) {
        return new R<>().setCode(CodeEnum.IS_SUCCESS.getCode()).setMsg("success").setResult(data);
    }
    public static R error(String code, String message) {
        return new R().setCode(code).setMsg(message).setResult(null);
    }


    public static R error(String message) {
        return new R().setCode(CodeEnum.IS_FAIL.getCode()).setMsg(message).setResult(null);
    }
}
