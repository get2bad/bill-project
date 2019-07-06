package com.wills.bill.springbootbill.service;

import com.wills.bill.springbootbill.bean.Bill;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface BillService {

    public Bill findById(Integer bid);

    public List<Bill> findAll();

    public void updateBillById(Bill bill);

    public void save(Bill bill);

    public void deleteById(Integer bid);
}
