package com.quark.admin.service;

import com.quark.common.base.BaseService;
import com.quark.common.dto.PageRaw;
import com.quark.common.entity.AdminUser;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by lhr on 17-8-1.
 */

public interface AdminUserService {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    AdminUser findByUserName(String username);

    /**
     * 根据翻页信息获取用户列表
     * @param adminUser
     * @param pageNo
     * @param length
     * @return
     */
    PageRaw<AdminUser> findByPage(AdminUser adminUser, int start, int length);

    /**
     * 保存用户
     * @param entity
     * @return
     */
    void saveAdmin(AdminUser entity);

    /**
     * 保存用户的角色
     * @param uid
     * @param roles
     * @return
     */
    void saveAdminRoles(Integer uid,Integer[] roles);

    /**
     * 开启/禁用用户
     * @param ids
     */
    void saveAdminEnable(Integer[] ids);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteUserByIds(Integer[] ids);

    AdminUser findByUserId(Integer userId);
}
