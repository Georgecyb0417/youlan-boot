package com.youlan.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlan.system.entity.User;
import com.youlan.system.entity.dto.UserPageDTO;
import com.youlan.system.entity.vo.UserVO;
import com.youlan.system.permission.anno.DataPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 用户分页
     */
    @DataPermission
    IPage<UserVO> getList(@Param("page") IPage<User> page, @Param("dto") UserPageDTO dto);

    /**
     * 用户列表
     */
    @DataPermission
    List<UserVO> getList(@Param("dto") UserPageDTO dto);
}
