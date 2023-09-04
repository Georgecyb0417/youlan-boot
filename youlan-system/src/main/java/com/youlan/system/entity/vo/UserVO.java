package com.youlan.system.entity.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.youlan.common.db.constant.DBConstant;
import com.youlan.common.db.enums.DBStatus;
import com.youlan.common.excel.anno.ExcelEnumProperty;
import com.youlan.common.excel.converter.EnumConverter;
import com.youlan.system.excel.anno.ExcelDictProperty;
import com.youlan.system.excel.converter.DictConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ColumnWidth(20)
@HeadFontStyle(fontHeightInPoints = 12)
@ExcelIgnoreUnannotated
public class UserVO {

    @ExcelProperty(value = "用户编号")
    @Schema(title = DBConstant.DESC_ID)
    private Long id;

    @Schema(title = "机构ID")
    private Long orgId;

    @ExcelProperty(value = "机构名称")
    @Schema(title = "机构名称")
    private String orgName;

    @ExcelProperty(value = "用户账号")
    @Schema(title = "用户账号")
    private String userName;

    @ExcelProperty(value = "用户手机")
    @Schema(title = "用户手机")
    private String userMobile;

    @Schema(title = "用户昵称")
    private String nickName;

    @ExcelProperty(value = "用户邮箱")
    @Schema(title = "用户邮箱")
    private String email;

    @Schema(title = "用户头像")
    private String avatar;

    @ExcelProperty(value = "用户性别", converter = DictConverter.class)
    @ExcelDictProperty("sys_user_sex")
    @Schema(title = "用户性别(字典类型[sys_user_sex])")
    private String sex;

    @ExcelProperty(value = "账号状态", converter = EnumConverter.class)
    @ExcelEnumProperty(value = DBStatus.class)
    @Schema(title = DBConstant.DESC_STATUS)
    private String status;

    @ExcelProperty(value = "最后登录IP")
    @Schema(title = "最后登录IP")
    private String loginIp;

    @ExcelProperty(value = "最后登录时间")
    @Schema(title = "最后登录时间")
    private String loginTime;

    @Schema(title = DBConstant.DESC_REMARK)
    private String remark;

    @Schema(title = DBConstant.DESC_CREATE_ID)
    private Long createId;

    @Schema(title = DBConstant.DESC_CREATE_BY)
    private String createBy;

    @Schema(title = DBConstant.DESC_UPDATE_ID)
    private Long updateId;

    @Schema(title = DBConstant.DESC_UPDATE_BY)
    private String updateBy;

    @Schema(title = DBConstant.DESC_CREATE_TIME)
    private Date createTime;

    @Schema(title = DBConstant.DESC_UPDATE_TIME)
    private Date updateTime;

    @Schema(title = "用户角色ID列表")
    private List<Long> roleIdList;

    @Schema(title = "用户关联岗位ID列表")
    private List<Long> postIdList;

    @Schema(title = "用户关联岗位名称列表")
    private List<String> postNameList;

    @Schema(title = "用户关联角色名称列表")
    private List<String> roleNameList;
}
