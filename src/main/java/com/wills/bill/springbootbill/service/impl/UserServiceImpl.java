package com.wills.bill.springbootbill.service.impl;

import com.wills.bill.springbootbill.bean.User;
import com.wills.bill.springbootbill.dao.UserDao;
import com.wills.bill.springbootbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.getOne(id);
    }

    @Override
    public Integer findAllUserCount() {
        return (int) userDao.count();
    }

    @Override
    public void changeUserInfo(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void insertUser(User user) {
        userDao.save(user);
    }

    @Override
    public void findByUserName(String userName) {

    }
}
