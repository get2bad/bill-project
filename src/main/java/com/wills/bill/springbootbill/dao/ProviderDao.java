package com.wills.bill.springbootbill.dao;

import com.wills.bill.springbootbill.bean.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderDao extends JpaRepository<Provider,Integer> {
}
