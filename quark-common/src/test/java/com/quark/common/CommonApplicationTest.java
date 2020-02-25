package com.quark.common;

import com.quark.common.dao.LabelDao;
import com.quark.common.dao.NotificationDao;
import com.quark.common.dao.PostsDao;
import com.quark.common.dao.UserDao;
import com.quark.common.entity.AdminUser;
import com.quark.common.mapper.AdminUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by lhr on 17-7-30.
 */
@RunWith(SpringRunner.class)
@EnableCaching//缓存支持
@SpringBootTest
public class CommonApplicationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDao UserDao;

    @Autowired
    private PostsDao postsDao;

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private NotificationDao notificationDao;
    @Autowired
    private AdminUserMapper userMapper;

    @Test
    public void testFindByUid() {
        AdminUser adminUser = userMapper.findByUid(3);
        System.out.println("get admin user:" + adminUser);
        assert (adminUser != null
                && adminUser.getId() == 3
                && adminUser.getRoles().size() > 0
        );
    }

    @Test
    public void testFindAll() {
        List<AdminUser> users = userMapper.findAll();
        System.out.println("users:" + users);
        assert (users != null && users.size() > 0);
    }

    @Test
    public void testFindByUsername() {
        AdminUser user = userMapper.findByUsername("lhr");
        System.out.println("testFindByUsername:" + user.getRoles());
        assert (user != null && user.getUsername().equals("lhr") && user.getRoles().size() > 0);
    }

    @Test
    public void testByAminuserIds() {
        Integer[] ids = {3, 11};
        List<AdminUser> users = userMapper.findByIds(ids);
        assert (users.size() == 2);
    }
    @Test
    public void testUpdateUsers(){
        Integer[] ids = {3, 11};
        List<AdminUser> users = userMapper.findByIds(ids);
        users.forEach(adminUser -> {
            if(adminUser.getEnable() == 1){
                adminUser.setEnable(0);
            }else{
                adminUser.setEnable(1);
            }
        });
        userMapper.updateUsersEnable(users);
        assert (true);
    }
    @Test
    public void testModifyUserRole(){
        userMapper.deleteAllRoleByUserId(11);
        Integer[] roleIds = {1,6};
        userMapper.insertUserRole(11,roleIds);
        assert(userMapper.findByUid(11).getRoles().size() == 2);
    }
    @Test
    public void findAdminByPage(){
        List<AdminUser> users = userMapper.findAdminUserByPage(1,5);
        assert (users.size() == 5);
    }
}
