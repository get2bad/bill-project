package com.wills.bill.springbootbill.service;

import com.wills.bill.springbootbill.bean.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Integer id);

    public Integer findAllUserCount();

    public void changeUserInfo(User user);

    public void deleteUserById(Integer id);

    public void insertUser(User user);

    public void findByUserName(String userName);
}
