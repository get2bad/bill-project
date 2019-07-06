package com.wills.bill.springbootbill.service.impl;

import com.wills.bill.springbootbill.bean.Provider;
import com.wills.bill.springbootbill.dao.ProviderDao;
import com.wills.bill.springbootbill.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderDao providerDao;

    @Override
    public Provider findById(Integer pid) {
        return providerDao.findById(pid).get();
    }

    @Override
    public void deleteById(Integer pid) {
        providerDao.deleteById(pid);
    }

    @Override
    public List<Provider> findAll() {
        return providerDao.findAll();
    }

    @Override
    public void updateBillById(Provider provider) {
        providerDao.save(provider);
    }

    @Override
    public void save(Provider provider) {
        providerDao.save(provider);
    }
}
