package com.quark.admin.service.impl;

import com.quark.admin.service.AdminUserService;
import com.quark.admin.service.RoleService;
import com.quark.admin.utils.PasswordHelper;
import com.quark.common.dto.PageRaw;
import com.quark.common.entity.AdminUser;
import com.quark.common.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lhr on 17-8-1.
 */
@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public AdminUser findByUserName(String username) {
        return adminUserMapper.findByUsername(username);
    }

    @Override
    public PageRaw<AdminUser> findByPage(AdminUser adminUser, int start, int length) {
        int total = adminUserMapper.totalAdminUsers();
        List<AdminUser> pageItems =  adminUserMapper.findAdminUserByPage(start,length);
        return new PageRaw(total,pageItems,start,length);

    }

    @Override
    public void saveAdmin(AdminUser entity) {
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(entity);
        adminUserMapper.saveUser(entity);
    }

    @Override
    public void saveAdminRoles(Integer uid, Integer[] roles) {
        adminUserMapper.deleteAllRoleByUserId(uid);
        adminUserMapper.insertUserRole(uid,roles);
    }

    @Override
    public void saveAdminEnable(Integer[] ids) {

        List<AdminUser> all = adminUserMapper.findByIds(ids);
        for (AdminUser user : all) {
            if (user.getEnable() == 1) {
                user.setEnable(0);
            } else {
                user.setEnable(1);
            }
        }
        adminUserMapper.updateUsersEnable(all);
    }

    @Override
    public void deleteUserByIds(Integer[] ids) {
        adminUserMapper.deleteUserByIds(ids);
    }

    @Override
    public AdminUser findByUserId(Integer userId) {
        return adminUserMapper.findByUid(userId);
    }
}
