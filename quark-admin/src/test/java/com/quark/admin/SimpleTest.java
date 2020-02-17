package com.quark.admin;

import com.quark.admin.utils.PasswordHelper;
import com.quark.common.entity.AdminUser;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void testPasswordEncrypt(){
        PasswordHelper helper = new PasswordHelper();
        AdminUser user = new AdminUser();
        user.setPassword("123456");
        user.setUsername("lhr");
        helper.encryptPassword(user);
        System.out.println("encypt password:"+user.getPassword());
        assert(true);
    }
}
