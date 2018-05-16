package com.example.jpa;

import com.example.jpa.dao.UserDao;
import com.example.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void saveUser()
    {
        User user = new User();
        user.setUsername("Chris Evans");
        user.setEmail("1762629204@qq.com");
        user.setPassword("1234656");
        userDao.save(user);
    }

    @Test
    public void findUser()
    {
        User user = userDao.findAll().get(0);
        System.out.println(user.getUsername());
    }

    @Test
    public void updateUser()
    {
        User user = userDao.findById(1).get();
        user.setUsername("Captain American");
        userDao.save(user);
    }

    @Test
    public void deleteUser()
    {
        User user = userDao.findAll().get(0);
        userDao.delete(user);
    }
}
