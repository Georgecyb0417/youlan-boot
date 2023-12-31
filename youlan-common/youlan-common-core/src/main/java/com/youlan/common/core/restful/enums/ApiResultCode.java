package com.youlan.common.core.restful.enums;

import com.youlan.common.core.exception.BizRuntimeException;
import com.youlan.common.core.spring.helper.MessageHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ApiResultCode {
    OK("00000", "OK"),
    WARN("00001", "WARN"),
    ERROR("11111", "ERROR"),

    // ********************** 用户类 **********************
    A0001("A0001", "用户名不存在"),
    A0002("A0002", "用户密码错误"),
    A0003("A0003", "用户未登录"),
    A0004("A0004", "用户权限异常"),
    A0005("A0005", "验证码请求过于频繁,请稍后再试"),
    A0006("A0006", "用户登录超出最大重试次数"),
    A0007("A0007", "验证码校验失败"),
    A0008("A0008", "验证码已过期,请刷新后再试"),
    A0009("A0009", "用户被禁用"),
    A0010("A0010", "验证码信息不存在"),
    A0011("A0011", "不允许操作管理员用户"),
    A0012("A0012", "当前用户不允许删除"),
    A0013("A0013", "无此用户操作权限"),
    A0014("A0014", "不允许操作管理员角色"),
    A0015("A0015", "无此角色操作权限"),
    A0016("A0016", "角色信息不存在"),
    A0017("A0017", "角色ID不存在"),
    A0018("A0018", "用户信息不存在"),
    A0019("A0019", "用户名已存在"),
    A0020("A0020", "用户手机已存在"),
    A0021("A0021", "无此机构操作权限"),

    // ********************** 功能类 **********************
    B0001("B0001", "文件导出失败"),
    B0002("B0002", "文件导入失败"),
    B0003("B0003", "参数解密失败"),
    B0004("B0004", "无法找到AES秘钥"),
    B0005("B0005", "上传文件不能为空"),
    B0006("B0006", "请求方法不支持"),
    B0007("B0007", "文件上传失败"),
    B0008("B0008", "存储URL格式不正确"),
    B0009("B0009", "存储文件不存在"),
    B0010("B0010", "存储文件名称不存在"),
    B0011("B0011", "存储对象ID不存在"),
    B0012("B0012", "存储URL不允许上跳"),
    B0013("B0013", "文件不是图片类型"),
    B0014("B0014", "字典类型不存在"),
    B0015("B0015", "字典类型被禁用"),
    B0016("B0016", "系统配置不存在"),
    B0017("B0017", "内置配置不能删除"),

    // ********************** 参数类 **********************
    C0001("C0001", "ID不能为空"),

    C0002("C0002", "参数校验失败"),

    C0003("C0003", "缺少路径参数"),

    C0004("C0004", "缺少表单参数"),

    C0005("C0005", "只允许传入单个元素"),

    // ********************** 组织机构类 **********************
    D0001("D0001", "机构信息不存在"),

    D0002("D0002", "机构已被禁用"),

    D0003("D0003", "机构ID不能为空"),

    D0004("D0004", "父级机构必须指定"),

    D0005("D0005", "父级机构被禁用"),

    D0006("D0006", "机构类型必须指定"),

    D0007("D0007", "机构名称必须指定"),

    D0008("D0008", "机构名称不能超过{0}个字符"),

    D0009("D0009", "部门信息不存在");

    /**
     * 响应码
     */
    private final String status;

    /**
     * 响应消息
     */
    private final String errorMsg;

    public String getErrorMsg() {
        return MessageHelper.message(this.errorMsg);
    }

    public String getErrorMsg(Object[] args) {
        return MessageHelper.message(this.errorMsg, args);
    }

    public BizRuntimeException getException() {
        return new BizRuntimeException(this);
    }

    public BizRuntimeException getException(Object... args) {
        return new BizRuntimeException(this, args);
    }
}
