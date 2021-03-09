package com.javakc.project.commons.base.response;

/**
 * @program: spring-boot-project
 * @description: 统一封装公共JSON编码
 * @author: zhou hong gang
 * @create: 2020-12-09 11:51
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),

    /* 参数错误：1001-1999 */
    PARAM_IS_BLANK(1001, "参数为空"),
    PARAM_IS_INVALID(1002, "参数无效"),
    PARAM_TYPE_ERROR(1003, "参数类型异常"),
    PARAM_NOT_COMPLETE(1004, "参数缺失异常"),

    /* 用户错误：2001-2999*/
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_LOGIN_SUCCESS(2003, "恭喜登陆成功"),
    USER_LOGIN_ERROR(2002, "账号或密码错误"),
    USER_ACCOUNT_LOCKED(2004, "账号已被锁定"),
    USER_ACCOUNT_FORBIDDEN(2005, "账号已被禁用"),
    USER_LOGIN_OTHER_ERROR(2006, "其他登陆失败"),
    USER_NOT_EXIST(2007, "用户不存在"),
    USER_PASS_ERROR(2008, "密码输入错误"),
    USER_LOGOUT_SUCCESS(2009, "退出成功"),

    /* 业务错误：3001-3999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(3001, "某业务出现问题"),

    /* 系统错误：4001-4999 */
    SYSTEM_INNER_ERROR(4001, "系统繁忙，请稍后重试"),

    /* 数据错误：5001-5999 */
    RESULT_DATA_NONE(5001, "数据未找到"),
    DATA_IS_WRONG(5002, "数据有误"),
    DATA_ALREADY_EXISTED(5003, "数据已存在"),
    DATA_HAS_BEEN_DELETED(5004,"数据已被删除"),

    /* 接口错误：6001-6999 */
    INTERFACE_INNER_INVOKE_ERROR(6001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(6002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(6003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(6004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(6005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(6006, "接口负载过高");

    //响应状态码
    private Integer code;
    //响应文本值
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
