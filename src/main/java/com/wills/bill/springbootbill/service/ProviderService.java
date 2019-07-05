package com.wills.bill.springbootbill.service;

import com.wills.bill.springbootbill.bean.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProviderService extends JpaRepository<Provider,Integer> {
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
}
