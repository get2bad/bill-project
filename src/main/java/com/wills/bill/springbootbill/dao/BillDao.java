package com.wills.bill.springbootbill.dao;

import com.wills.bill.springbootbill.bean.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDao extends JpaRepository<Bill,Integer> {
}
