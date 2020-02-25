package com.quark.common.mapper;

import com.quark.common.entity.AdminUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminUserMapper {
    List<AdminUser> findAll();

    AdminUser findByUsername(@Param("username") String username);

    AdminUser findByUid(@Param("id") int id);

    void saveUser(@Param("user") AdminUser user);

    List<AdminUser> findByIds(@Param("ids") Integer[] ids);

    void updateUsersEnable(@Param("users") List<AdminUser> users);

    void deleteAllRoleByUserId(@Param("userId") Integer userId);

    void insertUserRole(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);

    List<AdminUser> findAdminUserByPage(@Param("start") int start,@Param("length") int length);

    void deleteUserByIds(@Param("userIds") Integer[] ids);

    int totalAdminUsers();
}
