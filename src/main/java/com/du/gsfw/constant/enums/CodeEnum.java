package com.du.gsfw.constant.enums;




public enum CodeEnum {

    IS_SUCCESS("000000", "操作成功"),
    IS_FAIL("000001", "操作失败"),
    IS_PARAM("000002", "参数错误"),
    IS_EXIST("000003", "数据已存在"),
    IS_NOT_EXIST("000004", "数据不存在"),
    IS_LOGIN_EXPIRE("000005", "登录已过期"),
    IS_EXCEPTION("000006", "系统异常");

    private String code;
    private String msg;

    CodeEnum() {
    }

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
