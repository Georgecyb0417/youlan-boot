package com.youlan.system.service;

import com.youlan.common.service.BaseServiceImpl;
import com.youlan.system.entity.SysRoleMenu;
import com.youlan.system.mapper.SysRoleMenuMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SysRoleMenuService extends BaseServiceImpl<SysRoleMenuMapper, SysRoleMenu> {
}