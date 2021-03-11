package com.zrk;

import com.zrk.entity.OjUser;
import com.zrk.mapper.OjUserMapper;
import com.zrk.service.OJUserService;
import com.zrk.util.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private OjUserMapper ojUserMapper;

    @Autowired
    private OJUserService ojUserService;

    @Test
    public void testRegister(){
        OjUser ojUser = new OjUser();
        ojUser.setUserAccount("zrk");
        ojUser.setUserPassword("123456");
        try{
            ojUserService.register(ojUser);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testFindAll(){
        List<OjUser> ojUsers = ojUserMapper.selectList(null);
        ojUsers.forEach(System.out::println);
    }

    @Test
    public void getMD5(){
        System.out.println(MD5.getMD5("12312"));
    }

    @Test
    public void login(){
        OjUser ojUser = new OjUser();
        ojUser.setUserAccount("zrk");
        ojUser.setUserPassword("1234506");
        ojUserService.login(ojUser);
    }
}
