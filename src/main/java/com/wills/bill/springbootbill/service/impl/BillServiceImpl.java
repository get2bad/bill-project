package com.wills.bill.springbootbill.service.impl;

import com.wills.bill.springbootbill.bean.Bill;
import com.wills.bill.springbootbill.dao.BillDao;
import com.wills.bill.springbootbill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("billService")
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;

    @Override
    public Bill findById(Integer bid) {
        return billDao.findById(bid).get();
    }

    @Override
    public List<Bill> findAll() {
        return billDao.findAll();
    }

    @Override
    public void updateBillById(Bill bill) {
        billDao.save(bill);
    }

    @Override
    public void save(Bill bill) {
        billDao.save(bill);
    }

    @Override
    public void deleteById(Integer bid) {
        billDao.deleteById(bid);
    }
}
