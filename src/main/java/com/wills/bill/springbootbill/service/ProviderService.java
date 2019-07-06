package com.wills.bill.springbootbill.service;

import com.wills.bill.springbootbill.bean.Provider;

import java.util.List;

public interface ProviderService {
    /*
    @Modifying
    @Transactional
    @Query("update provider w set " +
            "hy.areaName = CASE WHEN :#{#huaYangArea.areaName} IS NULL THEN hy.areaName ELSE :#{#huaYangArea.areaName} END ," +
            "hy.areaPerson = CASE WHEN :#{#huaYangArea.areaPerson} IS NULL THEN hy.areaPerson ELSE :#{#huaYangArea.areaPerson} END ," +
            "hy.updateDate = CASE WHEN :#{#huaYangArea.updateDate} IS NULL THEN hy.updateDate ELSE :#{#huaYangArea.updateDate} END ," +
            "hy.updateId =  CASE WHEN :#{#huaYangArea.updateId} IS NULL THEN hy.updateId ELSE :#{#huaYangArea.updateId} END " +
            "where hy.uid = :#{#huaYangArea.uid}")
    int update(@Param("provider") Provider  provider);
    */

    public Provider findById(Integer pid);

    public List<Provider> findAll();

    public void updateBillById(Provider provider);

    public void save(Provider provider);

    public void deleteById(Integer pid);
}
