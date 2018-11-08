package com.zlj.order.repository;

import com.zlj.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tori
 * 2018/8/6 下午3:13
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
