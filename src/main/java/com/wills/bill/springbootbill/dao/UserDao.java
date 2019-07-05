package com.wills.bill.springbootbill.dao;

import com.wills.bill.springbootbill.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {


}
